package com.johnny.customerapi.controller;

import com.johnny.customerapi.domain.customer.*;
import com.johnny.customerapi.infra.exceptions.CustomerNotFoundException;
import com.johnny.customerapi.service.AddressService;
import com.johnny.customerapi.service.CustomerService;
import com.johnny.customerapi.service.ScheduleService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@SecurityRequirement(name = "bearer-key")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<Page<CustomerGetDTO>> getCustomers(@PageableDefault(size = 5, sort = {"name"}) Pageable pageable){
        var page = customerService.getCustomers(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CustomerGetDTO>> getCustomersById(@PathVariable String id) throws CustomerNotFoundException {
        var page = customerService.getCustomersById(id);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity<CustomerReturnDTO> createCustomer(@RequestBody @Valid CustomerDTO customerDto, UriComponentsBuilder uriComponentsBuilder){
        Customer customer = new Customer(customerDto);
        customer = addressService.updateAddress(customer);
        customerService.save(customer);
        var uri = uriComponentsBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomerReturnDTO(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCustomer(@PathVariable String id, @RequestBody CustomerUpdateDTO customerUpdateDTO) throws CustomerNotFoundException {
        var customerUpdated = customerService.update(id, customerUpdateDTO);
        return ResponseEntity.ok(new CustomerReturnDTO(customerUpdated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable String id) throws CustomerNotFoundException {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Schedule
     */
    public void scheduleUpdateCustomersWithoutAddress(){
        scheduleService.updateCustomerAddress();
    }
}
