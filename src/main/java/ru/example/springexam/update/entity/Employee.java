package ru.example.springexam.update.entity;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.example.springexam.update.entity.base.ObservableChangeEntity;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
public class Employee extends ObservableChangeEntity {

    @NotEmpty
    private String name;

    @Min(18)
    @Max(60)
    private Integer age;

}
