package com.example.oauth2login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/user")
    public String user(Principal principal) {
        return "Hello, " + principal.getName();
    }

    @GetMapping("/user-home")
    public String home() {
        return "Welcome to the User Home Page!";
    }
}
