package com.example.employeeapp.dao;

import com.example.employeeapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    public static List<Employee> EMPLOYEE_LIST;

    @Autowired
    public EmployeeDao(ApplicationContext context) {
        // read the <bean id="employeeList"> from employee.xml
        EMPLOYEE_LIST = (List<Employee>) context.getBean("employeeList");
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}
