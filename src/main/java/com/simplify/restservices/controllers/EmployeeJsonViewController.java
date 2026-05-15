package com.simplify.restservices.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.simplify.restservices.entities.Employee;
import com.simplify.restservices.entities.EmployeesView;
import com.simplify.restservices.entities.User;
import com.simplify.restservices.services.EmployeeService;
import com.simplify.restservices.services.UserService;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/jsonview/employees")
public class EmployeeJsonViewController {

    private EmployeeService employeeService;

    public EmployeeJsonViewController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @JsonView(EmployeesView.Normal.class)
    @GetMapping("/normal/{id}")
    public ResponseEntity<Employee> getEmployeeNormalById(@PathVariable @Min(1) Integer id) {
        return new ResponseEntity<>(this.employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @JsonView(EmployeesView.Manager.class)
    @GetMapping("/manager/{id}")
    public ResponseEntity<Employee> getEmployeeManagerById(@PathVariable @Min(1) Integer id) {
        return new ResponseEntity<>(this.employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @JsonView(EmployeesView.HR.class)
    @GetMapping("/hr/{id}")
    public ResponseEntity<Employee> getEmployeeExternalById(@PathVariable @Min(1) Integer id) {
        return new ResponseEntity<>(this.employeeService.getEmployeeById(id), HttpStatus.OK);
    }

}
