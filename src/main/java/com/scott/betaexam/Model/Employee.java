package com.scott.betaexam.Model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@Table(name="employee")
@Component
public class Employee {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "Employee_Id", unique = true)
    private UUID id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    @Email(message ="Email format is invalid")
    private String email;
    @Column(name = "Address_line1")
    private String address_line1;
    @Column(name = "City")
    private String city;
    @Column(name = "State")
    private String state;
    @Column(name = "Create_Date",columnDefinition = "DATETIME(3)")
   // @UpdateTimestamp
    @CreationTimestamp
    private LocalDateTime create_date;

    @PrePersist
    public void onCreate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        this.create_date = LocalDateTime.parse(simpleDateFormat.format(new Date()));
        System.out.println(create_date);
    }

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "Create_Date", nullable = false)
//    private Date create_date;
//    @PrePersist
//    protected void onCreate() {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
//        this.create_date = simpleDateFormat.format(new Date());
//    }

}
