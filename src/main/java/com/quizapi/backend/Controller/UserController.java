package com.quizapi.backend.Controller;

import com.quizapi.backend.Persistency.Entities.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

    @PostMapping("/quizapp/register")
    @ResponseBody
    public User register(@RequestBody User user) {
        log.info("USERNAME " + user.toString());
        User newUser = new User(user.getUsername(), user.getPassword());
        User user2 = new User("user122", "abcd");
        log.info("USER2 " + user2.toString());
        return newUser;
    }

    @GetMapping("quizapp/login")
    @ResponseBody
    public User login() {
        User newUser = new User("Username", "passwort");
        User user2 = new User("user122", "abcd");
        log.info("HELLO! " + newUser.toString());
        log.info("USER2 " + user2.toString());
        return newUser;
    }
}
