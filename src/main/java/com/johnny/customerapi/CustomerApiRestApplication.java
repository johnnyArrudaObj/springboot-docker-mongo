package com.johnny.customerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableMongoRepositories
@EnableFeignClients
@EnableScheduling
public class CustomerApiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApiRestApplication.class, args);
    }

}
