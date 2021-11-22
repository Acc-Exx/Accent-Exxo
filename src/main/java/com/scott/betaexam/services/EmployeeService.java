package com.scott.betaexam.services;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee(){
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAllEmployee().forEach(emp-> employeeList.add(emp));
        return employeeList;
    }

    public UUID saveEmployee(Employee emp){
       return employeeRepository.save(emp).getId();

    }

    public List<Employee> findAllEmployeeBYName(String name) {

        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAllEmployeeBYName(name).forEach(emp-> employeeList.add(emp));
        return employeeList;
    }
}
