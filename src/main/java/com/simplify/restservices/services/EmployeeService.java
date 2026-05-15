package com.simplify.restservices.services;

import com.simplify.restservices.entities.Employee;
import com.simplify.restservices.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(Integer id) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);

        if(optionalEmployee.isPresent()) {
            return  optionalEmployee.get();
        }

        return null;
    }
}
