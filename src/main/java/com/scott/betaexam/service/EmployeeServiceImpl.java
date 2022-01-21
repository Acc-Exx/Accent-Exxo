package com.scott.betaexam.service;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    final
    EmployeeRepository empRepository;

    public EmployeeServiceImpl(EmployeeRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) empRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return  empRepository.save(employee);
    }


    @Override
    public List<Employee> findByEmpName(String name) {

        Optional<List<Employee>> optional = Optional.ofNullable(empRepository.findByEmpName(name));
        List<Employee> employee;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found with name :: " + name);
        }
        return employee;

    }

    @Override
    public List<Employee> findByEmpEmail(String email) {

        Optional<List<Employee>> optional = Optional.ofNullable(empRepository.findByEmpEmail(email));
        List<Employee> employee;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found with email :: " + email);
        }
        return employee;

    }


}
