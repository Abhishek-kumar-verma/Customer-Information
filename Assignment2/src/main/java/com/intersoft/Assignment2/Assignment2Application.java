package com.intersoft.Assignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.intersoft.Assignment2.repository")
@ComponentScan(basePackages="com.intersoft.Assignment2.service")
@ComponentScan(basePackages="com.intersoft.Assignment2.repository.CountriesRepository")
public class Assignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment2Application.class, args);
	}

}
