package com.johnny.customerapi.repository;

import com.johnny.customerapi.domain.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositoryMongoDb extends MongoRepository<Customer, String> {
}
