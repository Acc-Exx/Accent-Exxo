package com.scott.betaexam.service;

import com.scott.betaexam.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findByEmpName(String name);
    List<Employee> findByEmpEmail(String name);
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
}
