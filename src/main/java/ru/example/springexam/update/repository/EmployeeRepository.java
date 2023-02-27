package ru.example.springexam.update.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.springexam.update.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
