package com.quizapi.backend.Persistency.Service;

import java.util.LinkedList;

import com.quizapi.backend.Persistency.Entities.User;

public interface UserService {
    boolean checkLogin(String loginname, String passsword);

    User registerUser(User newUser);

    User findUser(String loginname);

    User updateScore(String loginname, int newScore);

    LinkedList<User> getAllUsers();
}
