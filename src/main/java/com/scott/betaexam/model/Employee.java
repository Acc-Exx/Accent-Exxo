package com.scott.betaexam.model;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
public class Employee {
 @NotNull
    private UUID id;
    private String name;
    private String email;
    private String addressLine1;
    private String city;
    private String state;
    private Timestamp createDate;

    public Employee(){

    }
    public Employee(UUID id , String name, String email, String addressLine1, String city, String state,Timestamp createDate){
        super();
        this.id = UUID.randomUUID();
        this.name=name;
        this.email=email;
        this.addressLine1=addressLine1;
        this.city=city;
        this.state=state;
        this.createDate=createDate;
    }
    @Override
    public String toString(){
       return "Employee [id="+id+",name="+name+",email="+email+",addressLine1="+addressLine1+",city="+city+",state="+state+",createDate="+createDate+"]";
    }

    public void setId(UUID id) {
        this.id = UUID.randomUUID();
    }

    @Id
    public UUID getId() {
        return UUID.randomUUID();
    }

}
