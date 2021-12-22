package com.scott.betaexam.service;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployeeDetails(Employee employee) {
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        LocalDateTime date = LocalDateTime.now();
        employee.setCreateDate(date.format(dateformat));

        if( ((Objects.nonNull(employee.getAddressLine1()) || !"".equalsIgnoreCase(employee.getAddressLine1()))
            && (Objects.nonNull(employee.getState()) || !"".equalsIgnoreCase(employee.getState()))
            && (Objects.nonNull(employee.getCity()) || !"".equalsIgnoreCase(employee.getCity())))
            || ((Objects.isNull(employee.getAddressLine1()) || "".equalsIgnoreCase(employee.getAddressLine1()))
                && (Objects.isNull(employee.getState()) || "".equalsIgnoreCase(employee.getState()))
                && (Objects.isNull(employee.getCity()) || "".equalsIgnoreCase(employee.getCity())))
        ){
            return employeeRepository.save(employee);
        }else {
            return null;
        }

        /*if(Objects.isNull(employee.getAddressLine1())){
            if(Objects.isNull(employee.getCity())){
                if(Objects.isNull(employee.getState())){
                    return employeeRepository.save(employee);
                }else{
                    return null;
                }
            }
        }
        return employeeRepository.save(employee);*/
    }

    @Override
    public List<Employee> getEmployeeDetails(Employee employee)  {
        List<Employee> list = null;

        if(employee==null){
            list =  employeeRepository.findAll();
        }
        else if(Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName()) ){
            list =  employeeRepository.findByNameContaining(employee.getName());
        }
        else if(Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail()) ){
            list =  employeeRepository.findByEmailContaining(employee.getEmail());
        }

     //   DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
     //   list =  list.stream().map(
     //           list1->list1.setCreateDate(list1.getCreateDate().format(dateformat.toString())))
      //          .collect(Collectors.toList());
        return list;
    }
}
