package com.scott.betaexam.service;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository empRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        boolean isValid = validateEmployee(employee);
        if(isValid) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            Date date = new Date();
            employee.setCreatedTimestamp(String.valueOf(dateFormat.format(date)));
            return empRepository.save(employee);
        } else {
            return null;
        }
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return getAllEmployees().stream().filter(x -> x.getName().contains(name)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeeByEmail(String email) {
        return getAllEmployees().stream().filter(x -> x.getEmail().contains(email)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }

    private boolean validateEmployee(Employee employee) {
        boolean isValid = false;
        if(Optional.ofNullable(employee.getEmail()).isPresent() && Optional.ofNullable(employee.getName()).isPresent()) {
            isValid = true;
            if(!(Optional.ofNullable(employee.getAddressLine1()).isPresent() && Optional.ofNullable(employee.getCity()).isPresent() && Optional.ofNullable(employee.getState()).isPresent())) {
                isValid = false;
            }
        }
        return isValid;
    }
}
