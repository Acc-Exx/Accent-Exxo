package com.scott.betaexam.service;

import com.scott.betaexam.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees(String name);
    public Employee getEmployeeByEmail(String email);
    public  Employee saveEmployee(Employee employee);
}
