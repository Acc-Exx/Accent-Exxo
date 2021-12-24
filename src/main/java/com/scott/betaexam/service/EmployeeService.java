package com.scott.betaexam.service;

import com.scott.betaexam.dao.EmployeeRepository;
import com.scott.betaexam.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployee(String name, String email){
        return employeeRepository.getEmployeeByNameOrEmailId(name, email);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

}
