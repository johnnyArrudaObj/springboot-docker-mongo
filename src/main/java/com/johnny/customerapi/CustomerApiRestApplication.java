package com.johnny.customerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CustomerApiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApiRestApplication.class, args);
    }

}
