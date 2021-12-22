package com.scott.betaexam.service;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.repository.EmployeeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployeeDetails(Employee employee) {
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy MM dd'T'HH:mm:ss.SSS");
        LocalDateTime date = LocalDateTime.now();
        employee.setCreateDate(date.format(dateformat));
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeeDetails() {
        List<Employee> list =  employeeRepository.findAll();
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy MM dd'T'HH:mm:ss.SSS");
        list =  list.stream().map(
                list1->list1.setCreateDate(list1.getCreateDate().format(dateformat.toString())))
                .collect(Collectors.toList());
        return list;
    }
}
