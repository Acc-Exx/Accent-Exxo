package com.scott.betaexam.service.impl;

import com.scott.betaexam.entity.Employee;
import com.scott.betaexam.repository.EmployeeRepository;
import com.scott.betaexam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService
{

    @Autowired
    private EmployeeRepository empRepo;

    @Override
    public List<Employee> globalSearch(String keyword) {
        List<Employee> employees=null;
        List<Employee> matchedEmployees=null;
        try{
            employees= (List<Employee>) empRepo.findAll();
            System.out.println("Employees retrieved: "+ employees);
            matchedEmployees=employees.stream().filter(emp->emp.toString().contains(keyword)).collect(Collectors.toList());
        }
        catch(Exception ex){
            throw ex;
        }
        return matchedEmployees;
    }

    @Override
    public void addOrUpdateEmployee(Employee emp) {

        try{
            DateTimeFormatter LONG_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
            emp.setCreatedDate(LONG_FORMATTER.format(LocalDateTime.now()));
            empRepo.save(emp);
        }
        catch(Exception ex)
        {

            throw ex;
        }


    }
}
