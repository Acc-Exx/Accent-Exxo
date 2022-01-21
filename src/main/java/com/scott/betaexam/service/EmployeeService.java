package com.scott.betaexam.service;

import com.scott.betaexam.dao.EmployeeRepository;
import com.scott.betaexam.model.Employee;
import com.scott.betaexam.model.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.modelmbean.ModelMBean;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;

    @Autowired
    ModelMapper modelMapper;

    public List<Employee> findByName(String name){
        List<Employee> employeeList=new ArrayList<>() ;
        employeeList=repo.findByName(name);
        return employeeList;
    }
    public List<Employee> findByEmail(String email){
        List<Employee> employeeList=new ArrayList<>() ;
        employeeList=repo.findByEmail(email);
        return employeeList;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){
        Employee employee=repo.save(modelMapper.map(employeeDTO,Employee.class));
      return  modelMapper.map(employee,EmployeeDTO.class);
    }
}
