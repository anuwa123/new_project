package com.example.spring_practical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringPracticalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPracticalApplication.class, args);
	}

}
