package com.scott.betaexam.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name="Employee")
@Component
public class EmployeeEntity {
    @Column(name = "employeeName")
    private String employeeName;
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;
    @Column(name = "employeeEmail")
    private String employeeEmail;
    @Column(name = "employeeCountry")
    private String employeeCountry;


}
