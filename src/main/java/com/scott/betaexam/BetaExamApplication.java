package com.scott.betaexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.scott.Repository")
//@ComponentScan(basePackages = "com.scott.*")
public class BetaExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetaExamApplication.class, args);
	}

}
