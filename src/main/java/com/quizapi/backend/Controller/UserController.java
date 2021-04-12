package com.quizapi.backend.Controller;

import com.quizapi.backend.Persistency.Entities.User;
import com.quizapi.backend.Persistency.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/quizapp/register")
    @ResponseBody
    public ResponseEntity<User> register(@RequestBody User user) {
        log.info("Incoming User " + user.toString());
        User newUser = userService.registerUser(user);
        if (newUser == null) {
            log.info("User could not be saved.");
            return ResponseEntity.notFound().build();
        } else {
            log.info("THE NEW USER " + newUser.toString());
            return ResponseEntity.ok(newUser);
        }
    }

    @PostMapping("quizapp/login")
    @ResponseBody
    public ResponseEntity<User> login(@RequestBody User user) {
        log.info("User wants to login: " + user.toString());
        if (userService.checkLogin(user.getUsername(), user.getPassword())) {
            log.info("User is ready to login");
            return ResponseEntity.ok(user);
        } else {
            log.info("User credentials are wrong");
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
