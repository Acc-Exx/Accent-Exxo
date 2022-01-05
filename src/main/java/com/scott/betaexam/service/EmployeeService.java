package com.scott.betaexam.service;

import com.scott.betaexam.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public List<Employee> getEmployeeByName(String name);
    public List<Employee> getEmployeeByEmail(String email);
}