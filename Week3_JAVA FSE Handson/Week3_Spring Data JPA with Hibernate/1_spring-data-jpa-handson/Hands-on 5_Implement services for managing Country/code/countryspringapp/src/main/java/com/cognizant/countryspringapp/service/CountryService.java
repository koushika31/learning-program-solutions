package com.cognizant.countryspringapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.countryspringapp.model.Country;
import com.cognizant.countryspringapp.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public Country getByCode(String code) {
        return repository.findById(code).orElse(null);
    }

    public void add(Country c) {
        repository.save(c);
    }

    public void update(Country c) {
        repository.save(c);
    }

    public void delete(String code) {
        repository.deleteById(code);
    }

    public List<Country> searchByPartialName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
