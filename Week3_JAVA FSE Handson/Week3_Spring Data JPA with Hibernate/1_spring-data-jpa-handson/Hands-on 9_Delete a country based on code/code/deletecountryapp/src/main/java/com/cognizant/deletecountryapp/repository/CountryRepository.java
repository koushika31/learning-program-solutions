package com.cognizant.deletecountryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.deletecountryapp.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
