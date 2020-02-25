package com.mockathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan(basePackages = "com.mockathon")

public class MockathonSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(MockathonSpringBootApplication.class, args);
	}
}