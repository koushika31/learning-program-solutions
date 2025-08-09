package com.example.jwtsecureapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return Arrays.asList(
            new Country("US", "United States"),
            new Country("DE", "Germany"),
            new Country("IN", "India"),
            new Country("JP", "Japan")
        );
    }

    static class Country {
        public String code;
        public String name;

        public Country(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }
}
