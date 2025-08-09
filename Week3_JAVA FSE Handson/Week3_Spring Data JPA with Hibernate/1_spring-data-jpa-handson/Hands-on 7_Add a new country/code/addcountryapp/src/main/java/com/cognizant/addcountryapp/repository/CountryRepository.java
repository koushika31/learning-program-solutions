package com.cognizant.addcountryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.addcountryapp.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
