package com.example.companymanagementsystem.controller;

import com.example.companymanagementsystem.model.Department;
import com.example.companymanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    // ✅ Add Department with Employees
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    // ✅ View all Departments and their Employees
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
