package com.scott.betaexam.dao;

import com.scott.betaexam.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query(nativeQuery = true, value = "select * from Employee emp where emp.name = :name or emp.email =:email")
    List<Employee> getEmployeeByNameOrEmailId(String name, String email);
}
