package com.example.springexam.database.entity;

import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.PostUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
//@DynamicUpdate //позволяет обновлять лишь нужные поля при генерации запроса
@Slf4j
public class Employee extends BaseEntity {

    @NotEmpty
    private String name;

    private Integer age;

    @Transient
    private Employee sourceData;

    @PostLoad
    public void afterLoad() throws CloneNotSupportedException {
        sourceData = new Employee();
        sourceData.setName(name);
        sourceData.setAge(age);
    }
    @PostUpdate
    public void postUpdate(){
        if (!name.equals(sourceData.name)) printDif("name", sourceData.name, name);
        if (!age.equals(sourceData.age)) printDif("age", sourceData.age.toString(), age.toString());
    }

    private void printDif(String name, String was, String now){
        log.info("Changed {}: {}->{}", name, was, now);
    }

}
