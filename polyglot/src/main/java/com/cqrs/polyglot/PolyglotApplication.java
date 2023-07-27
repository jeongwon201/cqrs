package com.cqrs.polyglot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableJpaRepositories(basePackages = "com.cqrs.polyglot.account.command")
@EnableMongoRepositories(basePackages = "com.cqrs.polyglot.account.query")
public class PolyglotApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolyglotApplication.class, args);
    }

}
