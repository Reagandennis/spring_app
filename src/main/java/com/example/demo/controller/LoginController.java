package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if (userService.isUserExist(user.getUsername())) {
            // Validate password here (you can use BCryptPasswordEncoder to match the passwords)
            return "Login successful!";
        }
        return "Invalid username or password!";
    }
}
