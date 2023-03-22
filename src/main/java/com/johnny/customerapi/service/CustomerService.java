package com.johnny.customerapi.service;

import com.johnny.customerapi.entity.customer.Customer;
import com.johnny.customerapi.entity.customer.CustomerGetDTO;
import com.johnny.customerapi.exceptions.CustomerNotFoundException;
import com.johnny.customerapi.repository.CustomerRepositoryMongoDb;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerService {

    @Autowired
    private final CustomerRepositoryMongoDb customerRepository;

    public Page<CustomerGetDTO> getCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable).map(CustomerGetDTO::new);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<CustomerGetDTO> getCustomersById(String id) throws CustomerNotFoundException {
        Optional<CustomerGetDTO> customerGetDTO = customerRepository.findById(id).map(CustomerGetDTO::new);
        if (customerGetDTO.isEmpty()){
            throw new CustomerNotFoundException("Customer not with this id: " + id);
        }
        return customerGetDTO;
    }
}
