package com.scott.betaexam.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class EmployeeDTO {


    private UUID employeeId;
    @NotBlank(message = "Name can't be empty")
    private String name;
    @NotBlank(message = "Email Id can't be empty")
    private String email;
    private String addressLine1;
    private String city;
    private String state;
    private Timestamp createDate;


}
