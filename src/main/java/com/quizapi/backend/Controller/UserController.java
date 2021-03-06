package com.quizapi.backend.Controller;

import java.util.LinkedList;

import com.quizapi.backend.Persistency.Entities.User;
import com.quizapi.backend.Persistency.Service.UserService;
import com.quizapi.backend.Utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = Constants.QUIZAPP)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<User> register(@RequestBody User user) {
        log.info("Incoming User " + user.toString());
        User newUser = userService.registerUser(user);
        if (newUser == null) {
            log.info("User could not be saved.");
            return ResponseEntity.notFound().build();
        } else {
            log.info("The new User is {}", newUser.toString());
            return ResponseEntity.ok(newUser);
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<User> login(@RequestBody User user) {
        log.info("User wants to login: " + user.toString());
        if (userService.checkLogin(user.getUsername(), user.getPassword())) {
            User newUser = userService.findUser(user.getUsername());
            log.info("User is ready to login");
            return ResponseEntity.ok(newUser);
        } else {
            log.info("User credentials are wrong");
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PostMapping("/update-score")
    @ResponseBody
    public ResponseEntity<User> updateScore(@RequestBody User user) {
        log.info("Updating the score of user {}", user.getUsername());
        User newUser = userService.updateScore(user.getUsername(), user.getScore());
        if (newUser == null) {
            log.info("User is not valid");
            return ResponseEntity.notFound().build();
        } else {
            log.info("Score of user {} has been updated", user.getUsername());
            return ResponseEntity.ok(newUser);
        }
    }

    @GetMapping("/get-all-users")
    @ResponseBody
    public ResponseEntity<LinkedList<User>> getAllUsers() {
        LinkedList<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
