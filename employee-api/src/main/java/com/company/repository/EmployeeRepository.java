package com.company.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.model.Employee;

@Repository
public class EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> findAll() {
        return employees;
    }

}
