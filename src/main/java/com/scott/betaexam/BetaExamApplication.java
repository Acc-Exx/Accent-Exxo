package com.scott.betaexam;

import com.scott.betaexam.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BetaExamApplication {

	public static void main(String[] args) {

		SpringApplication.run(BetaExamApplication.class, args);
	}

}
