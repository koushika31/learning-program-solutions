package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        System.out.println("Application started...");
        displayDate(); // Call to the method defined below
    }

    public static void displayDate() {
        // Load Spring context from the XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

        // Get SimpleDateFormat bean from Spring container
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

        try {
            // Parse the date string
            Date date = format.parse("31/12/2018");
            System.out.println("Parsed Date: " + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
