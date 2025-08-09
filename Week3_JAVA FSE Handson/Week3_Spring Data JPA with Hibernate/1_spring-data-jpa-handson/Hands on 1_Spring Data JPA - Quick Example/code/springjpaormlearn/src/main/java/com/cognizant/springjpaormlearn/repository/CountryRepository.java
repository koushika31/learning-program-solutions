package com.cognizant.springjpaormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.springjpaormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
