package com.johnny.customerapi.controller;

import com.johnny.customerapi.entity.Customer;
import com.johnny.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/")
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping("/")
    public Customer createCustomers(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
}
