package com.example.lab4_20206442.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employees")
    private Integer employee_id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "hire_date")
    private LocalDateTime hire_date;

    @Column(name = "job_id")
    private String job_id;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "commission_pct")
    private Double commission_pct;

    @Column(name = "manager_id")
    private Integer manager_id;

    @Column(name = "department_id")
    private Integer department_id;

    @Column(name = "enabled")
    private Integer enabled;
}
