package com.scott.betaexam.service;

import com.scott.betaexam.vo.EmployeeVO;

import java.util.List;

public interface BetaExamService {
   public List<EmployeeVO> getEmployeeDetails();
   public String saveOrUpdateEmployeeDetails(EmployeeVO employeeVO);
   public List<EmployeeVO> getEmployeeDetailsByEmail(String id);
   public List<EmployeeVO> getEmployeeDetailsByName(String id);

}
