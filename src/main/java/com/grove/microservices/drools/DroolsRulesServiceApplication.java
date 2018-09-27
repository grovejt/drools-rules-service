package com.grove.microservices.drools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.grove.microservices.drools")
public class DroolsRulesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroolsRulesServiceApplication.class, args);
	}
}
