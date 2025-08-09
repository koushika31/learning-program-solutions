package com.example.companymanagementsystem.repository;

import com.example.companymanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
