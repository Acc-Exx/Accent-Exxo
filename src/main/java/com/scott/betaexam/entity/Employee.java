package com.scott.betaexam.entity;
import com.scott.betaexam.Validator.EmployeeAddressValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
@ToString
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EmployeeAddressValidator
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;
    @NotBlank(message="Name should not be Blank")
    private String name;
    @NotBlank(message="Name should not be Blank")
    private String email;
    private String state;
    private String  addressline1;
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime created_at;

    public Employee(String name, String email, String state, String addressline1) {
        this.name = name;
        this.email = email;
        this.state = state;
        this.addressline1 = addressline1;
    }
}
