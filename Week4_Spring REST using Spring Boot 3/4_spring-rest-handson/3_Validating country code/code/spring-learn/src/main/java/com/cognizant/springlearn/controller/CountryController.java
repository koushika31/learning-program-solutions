package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("Start");

        // Manual validation (will be replaced by global exception handler in Exercise 4)
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Country>> violations = validator.validate(country);
        List<String> errors = new ArrayList<>();

        for (ConstraintViolation<Country> violation : violations) {
            errors.add(violation.getMessage());
        }

        if (!errors.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
        }

        LOGGER.info("Code: {}", country.getCode());
        LOGGER.info("Name: {}", country.getName());

        return country;
    }
}
