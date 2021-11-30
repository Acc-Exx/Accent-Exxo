package com.scott.betaexam.dao;

import com.scott.betaexam.model.Employee;
import com.scott.betaexam.model.Employees;

public class EmployeeDAO {
    private static Employees list= new Employees();
    public Employees getAllEmployees(){
        return list;
    }

public void addEmployee (Employee employee)
{
    list.getEmployeeList().add(employee);
}
}
