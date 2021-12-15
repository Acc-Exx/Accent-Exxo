package com.scott.betaexam.manager;

import com.scott.betaexam.entity.Employee;

import java.util.List;
public interface EmployeeManager  {

    public List<Employee> search(String keyword);
    public void InsertOrUpdateEmployee(Employee employee);


}
