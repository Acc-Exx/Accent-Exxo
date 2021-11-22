package com.scott.betaexam.repository;

import com.scott.betaexam.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IEmployeeRepository extends JpaRepository<Employee, UUID> {

    @Query("select emp from Employee emp")
    public List<Employee> findAllEmployee();


    @Query("select emp from Employee emp where emp.name like %?1%  or emp.email like %?1% " )
    public List<Employee> findAllEmployeeBYName(String name);


}
