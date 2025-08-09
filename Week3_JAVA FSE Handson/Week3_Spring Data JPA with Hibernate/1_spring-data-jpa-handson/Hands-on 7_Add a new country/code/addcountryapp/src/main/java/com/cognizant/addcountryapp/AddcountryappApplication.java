package com.cognizant.addcountryapp;

import com.cognizant.addcountryapp.model.Country;
import com.cognizant.addcountryapp.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AddcountryappApplication {

    private static CountryService countryService;
    private static final Logger LOGGER = LoggerFactory.getLogger(AddcountryappApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AddcountryappApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testAddCountry();
    }

    private static void testAddCountry() {
        LOGGER.info("Start");

        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Zelandia");

        countryService.addCountry(country);

        Country added = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Added Country: {}", added);

        LOGGER.info("End");
    }
}
