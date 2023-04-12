package com.johnny.customerapi.repository;

import com.johnny.customerapi.domain.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Query("{'confirmedAddress': ?0}")
    List<Customer> getCustomersWithoutAddress(Boolean completeAddress);
}
