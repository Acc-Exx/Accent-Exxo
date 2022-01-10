package com.scott.betaexam.Service;

import com.scott.betaexam.Model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> retrieveEmployees(String name, String email);

   // List<Employee> retrieveEmployees(String name, UUID uuid);

  //  List<Employee> retrieveEmployees(String name);
}
