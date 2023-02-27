package ru.example.springexam.update.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.springexam.update.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
