package com.simplify.restservices.entities;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(EmployeesView.Normal.class)
    private Integer empid;
    @JsonView(EmployeesView.Normal.class)
    private String name;

    @JsonView(EmployeesView.Normal.class)
    private String department;

    @JsonView(EmployeesView.Manager.class)
    private LocalTime loginTime;

    @JsonView(EmployeesView.Manager.class)
    private LocalTime logoutTime;

    @JsonView(EmployeesView.HR.class)
    private Double salary;

    @JsonView(EmployeesView.HR.class)
    private LocalDate lastPromotionDate;
}
