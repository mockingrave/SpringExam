package ru.example.springexam;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.example.springexam.update.entity.Employee;
import ru.example.springexam.update.entity.Vehicle;
import ru.example.springexam.update.service.DetectService;
import ru.example.springexam.update.service.EmployeeService;
import ru.example.springexam.update.service.VehicleService;

@SpringBootTest
@Slf4j
@DisplayName("Обнаружение изменений при UPDATE")
class UpdateRowTest {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    DetectService detectService;


    @Test()
    @DisplayName("Использование @PostLoad и @PostUpdate")
    void detectByPostLoadPostUpdate() {

        var entity1 =
            Employee.builder()
                .id(0L)
                .name("Василий-Новый")
                .age(33)
                .build();

        employeeService.updateEmployee(entity1);

    }

    @Test()
    @DisplayName("Использование REQUIRED_NEW")
    @Transactional
    void detectByNewTransaction() {

        var entity1 =
            Vehicle.builder()
                .id(0L)
                .name("Авто-Новое")
                .mileage(123)
                .build();
        var updated = vehicleService.updateVehicle(entity1);

        detectService.detectUpdate(updated);

    }

}
