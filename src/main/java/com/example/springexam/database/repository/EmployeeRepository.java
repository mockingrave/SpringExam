package com.example.springexam.database.repository;

import com.example.springexam.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
