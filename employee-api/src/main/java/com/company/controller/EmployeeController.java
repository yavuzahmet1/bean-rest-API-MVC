package com.company.controller;
import com.company.model.Employee;
import com.company.model.UpdateEmployeeRequest;
import com.company.service.EmployeeService;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/list")
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();

    }

    @GetMapping(path="/list/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/list-with-params")
    public List<Employee> getEmployeesWithParams(@RequestParam(name="firstName", required=false) String firstName, @RequestParam(name="lastName", required=false) String lastName){
     
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }

    @PostMapping("/save-employee")
    public Employee saveEmployee(@RequestBody Employee newEmployee) {
        
        return employeeService.saveEmployee(newEmployee);
    }

    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable String id) {
        
        return employeeService.deleteEmployee(id) ? "Employee with ID " + id + " deleted successfully." : "Employee with ID " + id + " not found.";
    
    }

    @PutMapping(path = "/update-employee/{id}")
    public Employee putMethodName(@PathVariable String id, @RequestBody UpdateEmployeeRequest requestEmployee) {
        
        
        return employeeService.updateEmployee(id, requestEmployee);
    }
}

