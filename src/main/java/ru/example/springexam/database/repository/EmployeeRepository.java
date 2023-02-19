package ru.example.springexam.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.springexam.database.entity.Employee;

//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
