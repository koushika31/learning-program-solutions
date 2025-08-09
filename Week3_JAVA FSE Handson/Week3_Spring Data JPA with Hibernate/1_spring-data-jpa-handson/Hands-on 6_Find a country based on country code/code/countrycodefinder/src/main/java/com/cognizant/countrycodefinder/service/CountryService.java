package com.cognizant.countrycodefinder.service;

import com.cognizant.countrycodefinder.model.Country;
import com.cognizant.countrycodefinder.repository.CountryRepository;
import com.cognizant.countrycodefinder.service.exception.CountryNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = repository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found for code: " + countryCode);
        }
        return result.get();
    }
}
