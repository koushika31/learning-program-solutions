package com.cognizant.countryspringapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.countryspringapp.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByNameContainingIgnoreCase(String name);
}
