package com.scott.betaexam.controller;


import com.scott.betaexam.service.BetaExamServiceImpl;
import com.scott.betaexam.vo.EmployeeVO;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/test")
public class BetaExamApplicationController {
    private  BetaExamServiceImpl betaExamService;
    @Autowired
    public void setBetaExamServiceImpl(BetaExamServiceImpl betaExamService){
        this.betaExamService = betaExamService;
    }
    @RequestMapping(method = {RequestMethod.GET}, path = "/getEmployeeDetails",headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<EmployeeVO>> getEmployeeDetails(){
        List<EmployeeVO> employees  = betaExamService.getEmployeeDetails();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.POST}, path = "/saveEmployeeDetails",headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> saveEmployeeDetails(@RequestBody EmployeeVO employeeVO){
        String message= betaExamService.saveOrUpdateEmployeeDetails(employeeVO);
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

    @GetMapping("/getEmployee/{emailId}")
    @ResponseBody
    public ResponseEntity<List<EmployeeVO>> getEmployeeDetailsByEmail(@PathVariable String emailId){
        boolean valid = EmailValidator.getInstance().isValid(emailId);
        List<EmployeeVO> employees ;
        if(valid) {
            employees  = betaExamService.getEmployeeDetailsByEmail(emailId);}
        else {
            employees = betaExamService.getEmployeeDetailsByName(emailId);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
