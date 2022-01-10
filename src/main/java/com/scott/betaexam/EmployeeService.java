package com.scott.betaexam;
import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public List<EmployeePojo> findAll() {
        List<EmployeePojo> emplist = new ArrayList<EmployeePojo>();
        employeeRepository.findAll().forEach(emplist::add);
        return emplist;
    }

    public EmployeePojo save(EmployeePojo employee) {

        return employeeRepository.save(employee);
    }

    public List<EmployeePojo> findOne(String name) {
        List<EmployeePojo> emplist = new ArrayList<>();
        employeeRepository.findAll().forEach(emplist::add);
        System.out.println(emplist);
        List emp=new ArrayList();
        if(name.contains("@"))
        {
             emp = emplist.stream().filter(i -> i.getEmail().contains(name)).collect(Collectors.toList());
        }else {
             emp = emplist.stream().filter(i -> i.getName().contains(name)).collect(Collectors.toList());
        }
        return emp;
    }


}
