package com.scott.betaexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
@ComponentScan(basePackages = "com.scott.betaexam.*")
public class BetaExamApplication {


    public static void main(String[] args) {
        SpringApplication.run(BetaExamApplication.class, args);
    }

}
