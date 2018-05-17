package com.example.employee.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Employee {

    @Id
    private int id;
    private String name;
    private int age;
    private String gender;
    private int companyId;
    private int salary;

    public Employee(String name, int age, String gender, int salary, int companyId, int id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.companyId = companyId;
        this.salary = salary;
    }
}
