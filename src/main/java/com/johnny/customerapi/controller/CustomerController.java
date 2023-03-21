package com.johnny.customerapi.controller;

import com.johnny.customerapi.entity.customer.Customer;
import com.johnny.customerapi.entity.customer.CustomerDTO;
import com.johnny.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping
    public Customer createCustomers(@RequestBody @Valid CustomerDTO customerDto){
        return customerRepository.save(new Customer(customerDto));
    }
}
