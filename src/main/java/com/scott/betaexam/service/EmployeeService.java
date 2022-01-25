package com.scott.betaexam.service;

import com.scott.betaexam.dao.EmployeeRepository;
import com.scott.betaexam.model.Employee;
import com.scott.betaexam.dto.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;

    @Autowired
    ModelMapper modelMapper;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


   /* public List<Employee> findByName(String name){
        List<Employee> employeeList=new ArrayList<>() ;
        employeeList=repo.findByName(name);
        return employeeList;
    }
    public List<Employee> findByEmail(String email){
        List<Employee> employeeList=new ArrayList<>() ;
        employeeList=repo.findByEmail(email);
        return employeeList;
    }*/

    public List<Employee> getEmployeeByNameOrEmailId(String name,String email){
        List<Employee> employeeList=new ArrayList<>() ;
        if(!StringUtils.isEmpty(email)){
         boolean isValidEmail=   VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
        }
        employeeList=repo.getEmployeeByNameOrEmail(name,email);
        return employeeList;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){
        Employee emp = Employee.builder().name(employeeDTO.getName()).email(employeeDTO.getEmail()).addressLine1(employeeDTO.getAddressLine1()).city(employeeDTO.getCity()).state(employeeDTO.getState()).createDate(new Timestamp(System.currentTimeMillis())).build();
        Employee employee=repo.save(emp);
      return  modelMapper.map(employee,EmployeeDTO.class);
    }
}
