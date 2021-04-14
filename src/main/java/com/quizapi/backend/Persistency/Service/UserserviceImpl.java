package com.quizapi.backend.Persistency.Service;

import com.quizapi.backend.Persistency.Entities.User;
import com.quizapi.backend.Persistency.Repository.UserRepository;

import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public boolean checkLogin(String loginname, String password) {
        try {
            User user = findUser(loginname);
            log.info("USER" + user.toString());
            if (user.getUsername().equals(loginname) && user.getPassword().equals(password)) {
                log.info("User exists and is valid.");
                return true;
            } else {
                log.info("User credentials are not valid");
                return false;
            }
        } catch (NullPointerException e) {
            log.error("User is not in Database Nullpointer");
        } catch (Exception e) {
            log.error("User is not in Database");
        }
        return false;
    }

    @Override
    public User registerUser(User newUser) {
        try {
            User checkUser = findUser(newUser.getUsername()); // Throws Exception
            if (checkUser == null) {
                return userRepo.save(newUser);
            }
        } catch (NonUniqueResultException e) {
            log.error("User is already taken", newUser);
            return null;
        } catch (Exception e) {
            log.error("User is already taken", newUser);
            return null;
        }
        return null;
    }

    @Override
    public User findUser(String loginname) {
        User user = userRepo.findByUsername(loginname);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public User updateScore(String loginname, int newScore) {
        User user = userRepo.findByUsername(loginname);
        if (user == null) {
            return null;
        } else {
            user.setScore(user.getScore() + newScore);
            userRepo.saveAndFlush(user);
            return user;
        }
    }
}
