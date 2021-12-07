package com.scott.betaexam.service;

import com.scott.betaexam.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> globalSearch(String keyword);

    public void addOrUpdateEmployee(Employee emp);
}
