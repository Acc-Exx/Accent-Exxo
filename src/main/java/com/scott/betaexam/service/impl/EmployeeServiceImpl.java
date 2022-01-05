package com.scott.betaexam.service.impl;

import com.scott.betaexam.entity.Employee;
import com.scott.betaexam.repository.EmployeeRepository;
import com.scott.betaexam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * This method will be used to save employee object.
     * @param employee
     * @return
     */
    @Override
    public Employee createEmployee(Employee employee){
        // Set created time
        employee.setCreatedTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
        return employeeRepository.save(employee);
    }

    /**
     * This method will retrieve employee information by name.
     * @param name
     * @return
     */
    @Override
    public List<Employee> getEmployeeByName(String name){
        return employeeRepository.findByEmailContaining(name);
    }

    /**
     * This method will retrieve information based on employee email.
     * @param email
     * @return
     */
    public List<Employee> getEmployeeByEmail(String email){
        return employeeRepository.findByEmailContaining(email);
    }
}
