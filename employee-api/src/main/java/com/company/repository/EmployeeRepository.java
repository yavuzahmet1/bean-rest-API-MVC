package com.company.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.company.model.Employee;
import com.company.model.UpdateEmployeeRequest;

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

    public Employee save(Employee newEmployee) {
        employees.add(newEmployee);
        return newEmployee;
    }
    public boolean deleteEmployee(String id) {

    return employees.removeIf(emp -> emp.getId().equals(id));
}
private Optional<Employee> findById(String id) {
    return employees.stream()
                    .filter(emp -> emp.getId().equals(id))
                    .findFirst();
}

public Employee updateEmployee(String id, UpdateEmployeeRequest updatedEmployee) {
    Optional<Employee> existingEmployee = findById(id);
    if (existingEmployee.isPresent()) {
        Employee newEmployee = existingEmployee.get();
        newEmployee.setFirstName(updatedEmployee.getFirstName());
        newEmployee.setLastName(updatedEmployee.getLastName());
        employees.add(newEmployee);
        return newEmployee;
    }
    return null;
 
      
}}