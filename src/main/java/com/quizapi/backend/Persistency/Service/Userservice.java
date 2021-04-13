package com.quizapi.backend.Persistency.Service;

import com.quizapi.backend.Persistency.Entities.User;

public interface UserService {
    boolean checkLogin(String loginname, String passsword);

    User registerUser(User newUser);

    User findUser(String loginname);

    void updateScore(String loginname);
}
