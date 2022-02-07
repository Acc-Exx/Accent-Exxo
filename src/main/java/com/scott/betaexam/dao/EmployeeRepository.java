package com.scott.betaexam.dao;

import com.scott.betaexam.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

    List<Employee> findBynameContains(String name);

    List<Employee> findByemailContains(String email);
}
