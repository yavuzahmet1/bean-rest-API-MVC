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

    public Employee getEmployeeById(String id) {
        return employees.stream()
                        .filter(emp -> emp.getId().equals(id))
                        .findFirst()
                        .orElse(null);
    }

    public List<Employee> getEmployeesWithParams(String firstName, String lastName) {

        return employees.stream()
                        .filter(emp -> (firstName == null || emp.getFirstName().equalsIgnoreCase(firstName)) &&
                                       (lastName == null || emp.getLastName().equalsIgnoreCase(lastName)))
                        .toList();
    }

}
