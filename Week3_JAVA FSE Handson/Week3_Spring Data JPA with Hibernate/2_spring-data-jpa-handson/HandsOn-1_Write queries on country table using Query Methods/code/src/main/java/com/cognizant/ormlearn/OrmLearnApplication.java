package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@SpringBootApplication
public class OrmLearnApplication {

    private static CountryRepository countryRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryRepository = context.getBean(CountryRepository.class);

        testFindByNameContaining();
        testFindByNameContainingOrderByNameAsc();
        testFindByNameStartingWith();
    }

    private static void testFindByNameContaining() {
        System.out.println("\n--- Countries containing 'ou' ---");
        List<Country> countries = countryRepository.findByNameContaining("ou");
        countries.forEach(System.out::println);
    }

    private static void testFindByNameContainingOrderByNameAsc() {
        System.out.println("\n--- Countries containing 'ou' sorted ASC ---");
        List<Country> countries = countryRepository.findByNameContainingOrderByNameAsc("ou");
        countries.forEach(System.out::println);
    }

    private static void testFindByNameStartingWith() {
        System.out.println("\n--- Countries starting with 'Z' ---");
        List<Country> countries = countryRepository.findByNameStartingWith("Z");
        countries.forEach(System.out::println);
    }
}
