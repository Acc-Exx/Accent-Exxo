package com.scott.betaexam.service;

import com.scott.betaexam.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public List<Employee> getEmployeeDetails(Employee employee);
    public Employee saveEmployeeDetails(Employee employee);

}
