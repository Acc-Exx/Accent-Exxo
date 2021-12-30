package com.scott.betaexam.service;

import com.scott.betaexam.entity.EmployeeEntity;

import java.util.List;

public interface ServiceImpl {
    public EmployeeEntity saveEmployee(EmployeeEntity emp);
    public List<EmployeeEntity> retrieveEmployee();
    public EmployeeEntity getEmployee(Long id);
    public EmployeeEntity updateEmployee(EmployeeEntity emp);
    public EmployeeEntity deleteEmployee(Long id);
}
