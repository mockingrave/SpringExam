package ru.example.springexam.update.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.springexam.update.entity.Employee;
import ru.example.springexam.update.repository.EmployeeRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    @Transactional
    public void updateEmployee(Employee inputEmployee){
        repository.save(inputEmployee);
    }

}
