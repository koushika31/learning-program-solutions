package com.cognizant.deletecountryapp;

import com.cognizant.deletecountryapp.model.Country;
import com.cognizant.deletecountryapp.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DeletecountryappApplication {

    private static CountryService countryService;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeletecountryappApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DeletecountryappApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testDeleteCountry();
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start");

        countryService.deleteCountry("ZZ");

        Country deleted = countryService.findCountryByCode("ZZ");
        if (deleted == null) {
            LOGGER.debug("Country with code ZZ successfully deleted.");
        } else {
            LOGGER.debug("Country still exists: {}", deleted);
        }

        LOGGER.info("End");
    }
}
