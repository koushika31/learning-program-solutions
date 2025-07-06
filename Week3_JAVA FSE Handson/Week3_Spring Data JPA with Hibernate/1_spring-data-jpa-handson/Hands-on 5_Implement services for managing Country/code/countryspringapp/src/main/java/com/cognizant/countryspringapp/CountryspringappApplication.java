package com.cognizant.countryspringapp;

import com.cognizant.countryspringapp.model.Country;
import com.cognizant.countryspringapp.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CountryspringappApplication {

    private static CountryService service;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CountryspringappApplication.class, args);
        service = context.getBean(CountryService.class);

        runTests();
    }

    public static void runTests() {
        System.out.println("✅ Find by Code:");
        System.out.println(service.getByCode("IN"));

        System.out.println("✅ Add:");
        Country c = new Country();
        c.setCode("ZZ");
        c.setName("Zelandia");
        service.add(c);

        System.out.println("✅ Update:");
        c.setName("New Zelandia");
        service.update(c);

        System.out.println("✅ Search by Partial Name:");
        service.searchByPartialName("land").forEach(System.out::println);

        System.out.println("✅ Delete:");
        service.delete("ZZ");
    }
}
