package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.cognizant.springlearn.model.Country;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        LOGGER.info("Start");
        LOGGER.info("Code: {}", country.getCode());
        LOGGER.info("Name: {}", country.getName());
        return country;
    }
}
