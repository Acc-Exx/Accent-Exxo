package com.scott.betaexam.managerImpl;

import com.scott.betaexam.entity.Employee;
import com.scott.betaexam.manager.EmployeeManager;
import com.scott.betaexam.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeManagerImpl implements EmployeeManager {


    private EmployeeRepo employeeRepo;


    public List<Employee> search(String keyword) {
        List<Employee> employees = null;
        List<Employee> employees1 = null;

        try{

            employees = (List<Employee>)employeeRepo.findAll();
            employees1 = employees.stream().filter(employee -> employee.toString().contains(keyword)).collect(Collectors.toList());
        }

        catch (Exception exception){
            throw exception;

        }
        return employees1;
    }


    public void InsertOrUpdateEmployee(Employee employee) {


        try{
            DateTimeFormatter LONG_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
            employee.setCreateDate(LONG_FORMATTER.format(LocalDateTime.now()));
            employeeRepo.save(employee);


        }

        catch (Exception exception){
            throw exception;

        }

    }




}
