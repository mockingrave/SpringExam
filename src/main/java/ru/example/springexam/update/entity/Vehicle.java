package ru.example.springexam.update.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

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

    @NotEmpty
    private String name;

    @PositiveOrZero
    private Integer mileage;

}
