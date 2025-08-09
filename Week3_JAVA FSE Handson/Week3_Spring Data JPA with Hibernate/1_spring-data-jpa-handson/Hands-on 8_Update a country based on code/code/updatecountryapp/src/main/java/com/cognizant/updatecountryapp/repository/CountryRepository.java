package com.cognizant.updatecountryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.updatecountryapp.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
