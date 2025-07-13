package com.cognizant.springlearn.controller;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // GET method to return all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // POST method to update employee (replace existing by ID)
    @PostMapping("/employees")
    public void updateEmployee(@RequestBody Employee emp) throws EmployeeNotFoundException {
        employeeService.updateEmployee(emp);
    }
}
