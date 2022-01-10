package com.scott.betaexam.Service;

import com.scott.betaexam.Model.Employee;
import com.scott.betaexam.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> retrieveEmployees(String name, String email) {

        List<Employee> empFilter = new ArrayList();
        List<Employee> employeeDb = this.employeeRepository.findAll();


        for(Employee e1:employeeDb)
        {
            //System.out.println(e1.getName());
            if(email!=null)
            {
                if((e1.getEmail().toLowerCase()).contains(email.toLowerCase())){
                    empFilter.add(e1);
                }
            }else if(name!=null) {
                if ((e1.getName().toLowerCase()).contains(name.toLowerCase())) {
                    empFilter.add(e1);
                }
            }
        }
        return empFilter;
    }

}
