package com.company.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.model.Employee;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", "John", "Doe"));
        employees.add(new Employee("2", "Jane", "Smith"));
        employees.add(new Employee("3", "Emily", "Johnson"));
        return employees;
       
    }
}