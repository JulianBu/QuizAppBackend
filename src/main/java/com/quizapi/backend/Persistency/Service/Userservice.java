package com.quizapi.backend.Persistency.Service;

import com.quizapi.backend.Persistency.Entities.User;

public interface Userservice {
    boolean checkLogin(String loginname, String passsword);

    User registerUser(User newUser);

    User findUser(String loginname);
}
