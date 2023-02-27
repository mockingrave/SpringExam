package ru.example.springexam.update.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import ru.example.springexam.update.entity.base.BaseEntity;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@DynamicUpdate
public class Vehicle extends BaseEntity {

    private String name;

    private Integer mileage;

}
