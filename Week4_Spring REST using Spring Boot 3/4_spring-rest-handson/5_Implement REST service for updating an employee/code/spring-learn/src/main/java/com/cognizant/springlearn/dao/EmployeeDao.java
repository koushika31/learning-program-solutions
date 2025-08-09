package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.*;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.*;

@Repository
public class EmployeeDao {
    private static List<Employee> employeeList = new ArrayList<>();

    @PostConstruct
    public void init() {
        Department dept = new Department(1, "IT");
        Skill skill1 = new Skill(1, "Java");
        Skill skill2 = new Skill(2, "Spring");

        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("John");
        emp.setSalary(50000.0);
        emp.setPermanent(true);
        emp.setDepartment(dept);
        emp.setSkills(Arrays.asList(skill1, skill2));

        employeeList.add(emp);
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public void updateEmployee(Employee emp) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == emp.getId()) {
                employeeList.set(i, emp);
                return;
            }
        }
        throw new RuntimeException("Employee not found: " + emp.getId());
    }
}
