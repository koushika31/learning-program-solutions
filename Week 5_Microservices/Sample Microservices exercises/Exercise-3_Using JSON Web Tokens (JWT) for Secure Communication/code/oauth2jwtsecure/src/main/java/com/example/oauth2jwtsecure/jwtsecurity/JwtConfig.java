package com.example.oauth2jwtsecure.jwtsecurity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${spring.jwt.secret}")
    private String secret;

    public String getSecret() {
        return secret;
    }
}