package ru.example.springexam.update.service;

import javax.persistence.EntityManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.springexam.update.entity.Vehicle;
import ru.example.springexam.update.repository.VehicleRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository repository;

    @Autowired
    EntityManager entityManager;

    public Vehicle getById(Long id){
        return repository.getById(id);
    }

    @Transactional
    public Vehicle updateVehicle(Vehicle updateEntity) {

        var entity = repository.getById(updateEntity.getId());
        entity.setName(updateEntity.getName());
        entity.setMileage(updateEntity.getMileage());
        return entity;

    }

}
