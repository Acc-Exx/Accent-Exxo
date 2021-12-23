package com.scott.betaexam.service;

import com.scott.betaexam.entity.EmployeeRepository;
import com.scott.betaexam.repository.Employee;
import com.scott.betaexam.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BetaExamServiceImpl implements BetaExamService{

    private final EmployeeRepository employeeRepository;
    private List<EmployeeVO> employeeVOList;
    @Autowired
    public BetaExamServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;

    }
    @Override
    public List<EmployeeVO> getEmployeeDetails() {
        employeeVOList = getAllEmployeeDetails();
        return employeeVOList;
    }

    @Override
    public String saveOrUpdateEmployeeDetails(EmployeeVO em){
        StringBuilder message = new StringBuilder();
        try {
            Employee employee = new Employee();
            if(em.getId()!=null && !em.getId().isEmpty()||!em.getId().equals(""))
             employee.setId(em.getId());
            else
                message.append("Employee ID must not Empty");
            if(em.getName()!=null && !em.getName().isEmpty()||!em.getName().equals(""))
              employee.setName(em.getName());
            else
              message.append("  Employee name is Invalid");

            employee.setAddressLine1(em.getAddressLine1());
            employee.setEmail(em.getEmail());
            if(em.getCity()!=null || em.getState()!=null){
                if(!em.getCity().isEmpty() && em.getAddressLine1().isEmpty())
                    message.append("Address Line should not be blank");
                else if(!em.getState().isEmpty() && em.getCity().isEmpty() && em.getAddressLine1().isEmpty())
                    message.append("Address Line and City should not be blank");
            }
            employee.setCity(em.getCity());
            employee.setState(em.getState());
            Date date = new Date();
            employee.setCreatedDate(date);
            if(message.toString().length() == 0) {
                employeeRepository.save(employee);
               message.append(employee);
            }
        }
        catch (Exception exception){
            message.append( "Not Inserted some error");
        }
        return message.toString();
    }

    @Override
    public List<EmployeeVO> getEmployeeDetailsByEmail(String id) {

       employeeVOList = getAllEmployeeDetails();

        return employeeVOList.stream().filter(e ->e.getEmail().equals(id)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeVO> getEmployeeDetailsByName(String id) {
        employeeVOList = getEmployeeDetails();
        return employeeVOList.stream().filter(e -> e.getName().contains(id)).collect(Collectors.toList());
    }

    private List<EmployeeVO> getAllEmployeeDetails(){
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeList::add);
        List<EmployeeVO> employeeVOList = new ArrayList<>();
        for (Employee em: employeeList) {
            EmployeeVO employeeVO = new EmployeeVO();
            employeeVO.setId(em.getId());
            employeeVO.setName(em.getName());
            employeeVO.setAddressLine1(em.getAddressLine1());
            employeeVO.setEmail(em.getEmail());
            employeeVO.setCity(em.getCity());
            employeeVO.setState(em.getState());
            employeeVO.setCreationDate(em.getCreatedDate().toString());
            employeeVOList.add(employeeVO);
        }
        return employeeVOList;
    }


}
