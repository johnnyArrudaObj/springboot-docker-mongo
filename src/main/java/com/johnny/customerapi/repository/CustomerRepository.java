package com.johnny.customerapi.repository;

import com.johnny.customerapi.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
