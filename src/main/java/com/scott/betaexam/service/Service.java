package com.scott.betaexam.service;

import com.scott.betaexam.dao.DataAccessLayer;
import com.scott.betaexam.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@org.springframework.stereotype.Service
@Component
public class Service implements ServiceImpl {
    @Autowired
    DataAccessLayer dataAccessLayer ;

    public EmployeeEntity saveEmployee(EmployeeEntity emp){
        EmployeeEntity emp1 = dataAccessLayer.save(emp);
        return emp1;
    }

    public List<EmployeeEntity> retrieveEmployee(){
        List<EmployeeEntity> eList = new ArrayList<EmployeeEntity>();
        eList = dataAccessLayer.findAll();
        return eList;
    }

    public EmployeeEntity getEmployee(Long id){
        try {
            Optional<EmployeeEntity> optional = dataAccessLayer.findById(id);
            EmployeeEntity emp = optional.get();
            System.out.println("------> " + emp);
            return emp;
        }catch (NoSuchElementException e){
            return null;
        }
    }
    public EmployeeEntity updateEmployee(EmployeeEntity emp){
        try {
            dataAccessLayer.save(emp);
            return emp;
        }catch (NoSuchElementException e){
            return null;
        }
    }
    public EmployeeEntity deleteEmployee(Long id){
        dataAccessLayer.deleteById(id);
        return null;
    }
}
