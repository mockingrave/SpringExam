package ru.example.springexam.database.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
//@DynamicUpdate //позволяет обновлять лишь нужные поля при генерации запроса
@Slf4j
@ToString
public class Employee extends BaseEntity {

    @NotEmpty
    private String name;

    private Integer age;

}
