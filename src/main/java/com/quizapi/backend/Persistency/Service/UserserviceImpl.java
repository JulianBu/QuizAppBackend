package com.quizapi.backend.Persistency.Service;

import com.quizapi.backend.Persistency.Entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserserviceImpl implements Userservice {

    @Autowired
    Userrepository userRepo;

    @Override
    public boolean checkLogin(String loginname, String password) {
        User user = findUser(loginname);
        if (user.getUsername().equals(loginname) && user.getPassword().equals(password)) {
            log.info("User exists and is valid.");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User registerUser(User newUser) {
        User checkUser = findUser(newUser.getUsername());
        if (checkUser == null) {
            return userRepo.save(newUser);
        }
        return null;
    }

    @Override
    public User findUser(String loginname) {
        User user = userRepo.findByUsername(loginname);
        if (user == null) {
            return user;
        }
        return null;
    }

}
