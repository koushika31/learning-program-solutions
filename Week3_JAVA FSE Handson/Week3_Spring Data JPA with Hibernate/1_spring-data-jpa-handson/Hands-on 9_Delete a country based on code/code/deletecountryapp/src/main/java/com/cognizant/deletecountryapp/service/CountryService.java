package com.cognizant.deletecountryapp.service;

import com.cognizant.deletecountryapp.model.Country;
import com.cognizant.deletecountryapp.repository.CountryRepository;
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
    public void deleteCountry(String code) {
        repository.deleteById(code);
    }
}
