package com.company.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.model.Employee;
import com.company.model.UpdateEmployeeRequest;
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

    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        return employeeRepository.getEmployeesWithParams(firstName, lastName);
    }

    public Employee saveEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

public boolean deleteEmployee(String id) {
    Employee employee = employeeRepository.getEmployeeById(id);
    if (employee != null) {
        employeeRepository.deleteEmployee(id); 
        return true;
    }
    return false;
}

public Employee updateEmployee(String id,UpdateEmployeeRequest requestEmployee){
    
    return employeeRepository.updateEmployee(id, requestEmployee);
}

}
