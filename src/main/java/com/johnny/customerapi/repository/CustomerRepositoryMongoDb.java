package com.johnny.customerapi.repository;

import com.johnny.customerapi.entity.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepositoryMongoDb extends MongoRepository<Customer, String> {
}
