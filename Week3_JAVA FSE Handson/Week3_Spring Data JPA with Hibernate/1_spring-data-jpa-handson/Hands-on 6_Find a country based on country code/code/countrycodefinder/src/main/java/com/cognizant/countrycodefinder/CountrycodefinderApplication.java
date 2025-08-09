package com.cognizant.countrycodefinder;

import com.cognizant.countrycodefinder.model.Country;
import com.cognizant.countrycodefinder.service.CountryService;
import com.cognizant.countrycodefinder.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CountrycodefinderApplication {

    private static CountryService countryService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CountrycodefinderApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CountrycodefinderApplication.class, args);
        countryService = context.getBean(CountryService.class);

        getAllCountriesTest();
    }

    private static void getAllCountriesTest() {
        LOGGER.info("Start");

        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }

        LOGGER.info("End");
    }
}
