package com.cognizant.addcountryapp.service;

import com.cognizant.addcountryapp.model.Country;
import com.cognizant.addcountryapp.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    @Transactional
    public void addCountry(Country country) {
        repository.save(country);
    }

    public Country findCountryByCode(String code) {
        return repository.findById(code).orElse(null);
    }
}
