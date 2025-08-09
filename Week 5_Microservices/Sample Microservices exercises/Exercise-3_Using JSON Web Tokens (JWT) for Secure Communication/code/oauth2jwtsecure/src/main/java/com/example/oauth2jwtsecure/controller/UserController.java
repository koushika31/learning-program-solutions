package com.example.oauth2jwtsecure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/secure")
    public ResponseEntity<String> secure(Authentication authentication) {
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
        String name = oauth2User.getAttribute("name");
        String email = oauth2User.getAttribute("email");
        return ResponseEntity.ok("Hello, " + name + " (" + email + ")");
    }
}
