package com.example.employee.entity;

import lombok.Data;

@Data
public class Employee {

    private int id;
    private String name;
    private int age;
    private String gender;
    private int companyId;
    private int salary;

    public Employee(String name, int age, String gender, int salary, int id, int companyId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.companyId = companyId;
        this.salary = salary;
    }
}
