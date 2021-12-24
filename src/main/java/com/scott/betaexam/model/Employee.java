package com.scott.betaexam.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "EMPLOYEE")
@Getter @Setter @ToString @AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Name shouldn't be blank")
    private String name;

    @Email(message = "Please provide valid email address")
    private String email;

    private String address;

    private String city;

    private String state;

    private String createDate;

    @PrePersist
    public void onCreate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        this.createDate = simpleDateFormat.format(new Date());
    }

    public Employee() {
    }

}
