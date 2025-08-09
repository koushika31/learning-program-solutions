package com.example.jwtsecureapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/countries")
    public List<String> getCountries() {
        return Arrays.asList("India", "USA", "UK");
    }
}