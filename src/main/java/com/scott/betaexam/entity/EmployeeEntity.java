package com.scott.betaexam.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name="Employee")
@Component
public class EmployeeEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;
    @Column(name ="employeeName")
    private String employeeName;
    @Column(name ="employeeEmail")
    private String employeeEmail;
    @Column(name ="firstAddressLine1")
    private String firstAddressLine1;
    @Column(name ="Street")
    private  String Street;
    @Column(name ="city")
    private String city;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdDate;

    @PrePersist
    private void onCreate(){
        createdDate=new Date();
    }


}
