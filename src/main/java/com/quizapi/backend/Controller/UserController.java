package com.quizapi.backend.Controller;

import java.net.URISyntaxException;

import com.quizapi.backend.Persistency.Entities.User;
import com.quizapi.backend.Persistency.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<User> register(@RequestBody User user) throws URISyntaxException {
        log.info("Incoming User " + user.toString());
        User newUser = userService.registerUser(user);
        if (newUser == null) {
            log.info("User could not be saved.");
            return ResponseEntity.ok(newUser);
        } else {
            log.info("THE NEW USER " + newUser.toString());
            return ResponseEntity.ok(newUser);
        }
    }

    @GetMapping("quizapp/login")
    @ResponseBody
    public User login() {
        User u = new User("user1222", "abcd");
        User newUser = userService.registerUser(u);

        // log.info("HELLO! " + newUser.toString());
        log.info("USER2 " + u.toString());
        return newUser;
    }
}
