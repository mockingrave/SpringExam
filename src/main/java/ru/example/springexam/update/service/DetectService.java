package ru.example.springexam.update.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.example.springexam.update.entity.Vehicle;

@Slf4j
@Service
@RequiredArgsConstructor
public class DetectService {

    private final VehicleService vehicleService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void detectUpdate(Vehicle vehicle){

        var oldValue = vehicleService.getById(vehicle.getId());
        var newValue = vehicle;

        log.info("Old Entity: {}", oldValue);
        log.info("New Entity: {}", newValue);
    }


}
