package com.cqrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableJpaRepositories(basePackages = "com.cqrs.account.command")
@EnableMongoRepositories(basePackages = "com.cqrs.account.query")
public class CqrsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CqrsApplication.class, args);
	}
}
