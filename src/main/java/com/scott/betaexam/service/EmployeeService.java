package com.scott.betaexam.service;

import com.scott.betaexam.Exception.EmployeeNotFoundException;
import com.scott.betaexam.dao.EmployeeRepository;
import com.scott.betaexam.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public  List<Employee> getEmployeeData(String name , String email) {
        List<Employee> employeeList = new ArrayList<>();
        if (name != null) {
            employeeList = employeeRepo.findBynameContains(name);
        } else if (email != null) {
            employeeList = employeeRepo.findByemailContains(email);
        }
        if( employeeList.size()==0){
            throw new EmployeeNotFoundException("Employee not available");
        }
        else return employeeList;
    }

    public Employee saveEmployee(Employee employee) {

        return employeeRepo.save(employee);
    }
}
