package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class SignupController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        if (userService.isUserExist(user.getUsername())) {
            return "User already exists!";
        }
        userService.signUpUser(user);
        return "Signup successful!";
    }
}
