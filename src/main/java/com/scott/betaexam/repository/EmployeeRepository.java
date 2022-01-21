package com.scott.betaexam.repository;

import com.scott.betaexam.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("select emp from Employee emp where emp.name like %?1%")
    List<Employee> findByEmpName(String chars);

    @Query("select emp from Employee emp where emp.email like %?1%")
    List<Employee> findByEmpEmail(String email);

}
