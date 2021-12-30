package com.scott.betaexam.entity;

import ch.qos.logback.core.net.server.ServerListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name="Employee")
@Component
@JsonIgnoreProperties(ignoreUnknown = true)

public class EmployeeEntity implements Serializable {
    private static final long serialVersionUID = -1927057943962033354L;
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "UUID", unique = true)
    private String uuid;
    @Column(name ="EMPLOYEE_NAME")
    private String employeeName;
    @Column(name ="EMPLOYEE_EMAIL")
    private String employeeEmail;
    @Column(name ="FIRST_ADDRESS_LINE1")
    private String firstAddressLine1;
    @Column(name="STATE")
    private  String state;
    @Column(name ="CITY")
    private String city;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE")
    private Date createdDate =new Date(System.currentTimeMillis());

}
