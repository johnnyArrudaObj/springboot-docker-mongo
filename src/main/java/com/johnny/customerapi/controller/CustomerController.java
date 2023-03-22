package com.johnny.customerapi.controller;

import com.johnny.customerapi.entity.customer.Customer;
import com.johnny.customerapi.entity.customer.CustomerDTO;
import com.johnny.customerapi.entity.customer.CustomerGetDTO;
import com.johnny.customerapi.exceptions.CustomerNotFoundException;
import com.johnny.customerapi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @GetMapping
    public ResponseEntity<Page<CustomerGetDTO>> getCustomers(@PageableDefault(size = 5, sort = {"name"}) Pageable pageable){
        return new ResponseEntity<>(customerService.getCustomers(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CustomerGetDTO>> getCustomersById(@PathVariable String id) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.getCustomersById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomers(@RequestBody @Valid CustomerDTO customerDto){
        return new ResponseEntity<>(customerService.save(new Customer(customerDto)), HttpStatus.CREATED);
    }
}
