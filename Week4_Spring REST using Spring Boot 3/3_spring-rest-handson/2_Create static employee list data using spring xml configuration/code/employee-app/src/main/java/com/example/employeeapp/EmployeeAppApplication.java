package com.example.employeeapp;

import com.example.employeeapp.dao.EmployeeDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:employee.xml")  // load your XML config
public class EmployeeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeAppApplication.class, args);
    }

    // Temporary test to print out the static list on startup
    @Bean
    public CommandLineRunner test(EmployeeDao employeeDao) {
        return args -> {
            System.out.println("=== Employee List from XML ===");
            employeeDao.getAllEmployees().forEach(System.out::println);
        };
    }
}
