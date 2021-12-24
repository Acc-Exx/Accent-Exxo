package com.scott.betaexam.Helper;

import com.scott.betaexam.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class FactorBeanClass {

    public FactorBeanClass() {
    }

    public List<Employee> populateEmployee(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Sam", "Sam@acc.com", "Downtown San Jose", "San Jose", "California"));
        return employeeList;
    }

}
