package com.cognizant.countrycodefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.countrycodefinder.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
