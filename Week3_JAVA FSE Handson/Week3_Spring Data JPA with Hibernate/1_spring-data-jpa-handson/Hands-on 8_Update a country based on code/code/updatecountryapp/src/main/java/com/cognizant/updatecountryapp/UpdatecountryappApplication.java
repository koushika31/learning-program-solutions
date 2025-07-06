package com.cognizant.updatecountryapp;

import com.cognizant.updatecountryapp.model.Country;
import com.cognizant.updatecountryapp.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UpdatecountryappApplication {

    private static CountryService countryService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdatecountryappApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UpdatecountryappApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testUpdateCountry();
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start");

        // Update country code "ZZ" to new name
        countryService.updateCountry("ZZ", "Zelandia Prime");

        Country updated = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Updated Country: {}", updated);

        LOGGER.info("End");
    }
}
