package com.example.springexam;

import java.util.HashMap;
import java.util.Map;

import com.example.springexam.database.entity.Employee;
import com.example.springexam.database.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringExamApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;
    private Employee saved;

    @Test
    void insertTest() {

        var entity1 =
            Employee.builder()
                .name("Василий")
                .age(22)
                .build();

        var saved = employeeRepository.save(entity1);

        entity1.setName("ВасилийNew");

        var saved2 = employeeRepository.save(entity1);

        System.out.println("end");
    }

    private Map<String, Object> difference(Employee employee){

        var found= employeeRepository.findById(employee.getId()).get();
        var saved = employeeRepository.save(employee);

        var result = new HashMap<String, Object>();

        if (!saved.getName().equals(found.getName())) result.put("name", saved.getName());
        if (saved.getAge() != found.getAge()) result.put("age", saved.getAge());

        return result;
    }


    private void findAndPrintEntity(Long id, String printedName) {

        var found =  employeeRepository.findById(id);
        log.info("{} = {}", printedName, found.get().getName());

    }
}
