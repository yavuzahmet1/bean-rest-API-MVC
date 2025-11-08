package com.company.controller;
import com.company.model.Employee;
import com.company.service.EmployeeService;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/rest/api")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/employee-list")
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();

}
}

