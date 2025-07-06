package com.cognizant.updatecountryapp.service;

import com.cognizant.updatecountryapp.model.Country;
import com.cognizant.updatecountryapp.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public Country findCountryByCode(String code) {
        return repository.findById(code).orElse(null);
    }

    @Transactional
    public void updateCountry(String code, String name) {
        Optional<Country> optional = repository.findById(code);
        if (optional.isPresent()) {
            Country country = optional.get();
            country.setName(name);
            repository.save(country);
        } else {
            System.out.println("Country with code " + code + " not found.");
        }
    }
}
