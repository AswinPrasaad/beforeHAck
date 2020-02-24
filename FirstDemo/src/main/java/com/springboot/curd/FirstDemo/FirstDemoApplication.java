package com.springboot.curd.FirstDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages="com.springboot.curd.FirstDemo")
//@EntityScan(basePackages="com.springboot.curd.FirstDemo.Model")
//@EnableJpaRepositories(basePackages="com.springboot.curd.FirstDemo.DemoDaoLayer")
public class FirstDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstDemoApplication.class, args);
	}

}
