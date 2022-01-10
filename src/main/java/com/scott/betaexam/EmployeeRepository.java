package com.scott.betaexam;
import java.util.List;
import java.util.UUID;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends  JpaRepository<EmployeePojo, UUID> {

    //List<EmployeePojo>findAll();

}
