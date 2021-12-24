package com.scott.betaexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.scott.betaexam.model")
@SpringBootApplication
public class BetaExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetaExamApplication.class, args);
	}

}
