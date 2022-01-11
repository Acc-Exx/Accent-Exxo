package com.scott.betaexam.repo;

import com.scott.betaexam.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    public List<Employee> findByNameContaining(String name);
    public Employee findByEmail(String email);
}
