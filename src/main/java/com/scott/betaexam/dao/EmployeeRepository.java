package com.scott.betaexam.dao;

import com.scott.betaexam.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    public List<Employee> findByName(String name);
    public List<Employee> findByEmail(String email);
}
