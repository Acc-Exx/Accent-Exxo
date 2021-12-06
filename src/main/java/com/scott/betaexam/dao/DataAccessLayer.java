package com.scott.betaexam.dao;

import com.scott.betaexam.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataAccessLayer extends JpaRepository<EmployeeEntity,Long>{
}
