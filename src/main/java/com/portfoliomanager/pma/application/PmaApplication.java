package com.portfoliomanager.pma.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.portfoliomanager.pma.domain.exception","com.portfoliomanager.pma.controller", "com.portfoliomanager.pma.service",
		"com.portfoliomanager.pma.mapper", "com.portfoliomanager.pma.dto" })
@EnableJpaRepositories(basePackages = { "com.portfoliomanager.pma.persistance" })
@EntityScan("com.portfoliomanager.pma.domain")
public class PmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmaApplication.class, args);
	}

}
