package com.example.companymanagementsystem.repository;

import com.example.companymanagementsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
