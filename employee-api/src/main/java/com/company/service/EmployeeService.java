package com.company.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.model.Employee;
import com.company.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

}
