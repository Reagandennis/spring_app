package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class PasswordRecoveryController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/recover")
    public String recoverPassword(@RequestBody String email) {
        User user = userRepository.findByUsername(email).orElse(null);
        if (user == null) {
            return "Email not found!";
        }
        // Add password recovery logic here (e.g., send a recovery email)
        return "Password recovery email sent!";
    }
}
