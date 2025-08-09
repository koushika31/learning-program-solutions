package com.example.oauth2login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/secure")
    public String secure() {
        return "This is a secure endpoint!";
    }

    @GetMapping("/secure-home")
    public String secureHome() {
        return "Welcome to the secure home page!";
    }
}
