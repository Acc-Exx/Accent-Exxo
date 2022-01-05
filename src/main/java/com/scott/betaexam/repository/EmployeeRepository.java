package com.scott.betaexam.repository;

import com.scott.betaexam.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    public List<Employee> findByNameContaining(String name);
    public List<Employee> findByEmailContaining(String email);
}
