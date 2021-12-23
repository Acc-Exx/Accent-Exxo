package com.scott.betaexam.service;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.repository.EmployeeRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public Employee saveEmployeeDetails(Employee employee) {
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        LocalDateTime date = LocalDateTime.now();
        employee.setCreateDate(LocalDateTime.parse(date.format(dateformat)));

        if( StringUtils.isEmpty(employee.getAddressLine1())
            && StringUtils.isEmpty(employee.getState())
            && StringUtils.isEmpty(employee.getCity()))
        {
            return employeeRepository.save(employee);
        }else if(!StringUtils.isEmpty(employee.getAddressLine1())
                && !StringUtils.isEmpty(employee.getState())
                && !StringUtils.isEmpty(employee.getCity()))
        {
            return employeeRepository.save(employee);
        }else {
            return null;
        }
    }

    @Override
    public List<Employee> getEmployeeDetails(Employee employee)  {
        List<Employee> list = null;

        if(Objects.isNull(employee)){
            list = employeeRepository.findAll();
        }
        else if(!StringUtils.isEmpty(employee.getName())){
            list = employeeRepository.findByNameContaining(employee.getName());
        }
        else if(!StringUtils.isEmpty(employee.getEmail())){
            list = employeeRepository.findByEmailContaining(employee.getEmail());
        }

        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        list =  Objects.nonNull(list) ? list.stream().map(
                    list1->{
                        list1.setCreateDate(LocalDateTime.parse(list1.getCreateDate().format(dateformat)));
                        return list1;
                    }).collect(Collectors.toList())
                :null;

        return list;
    }
}
