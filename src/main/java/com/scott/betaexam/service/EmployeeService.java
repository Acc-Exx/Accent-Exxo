package com.scott.betaexam.service;

import com.scott.betaexam.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public List<Employee> getEmployeeByName(String name);
    public List<Employee> getEmployeeByEmail(String email);
    public List<Employee> getAllEmployees();
}
