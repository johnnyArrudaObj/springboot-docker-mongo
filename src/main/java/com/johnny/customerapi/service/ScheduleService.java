package com.johnny.customerapi.service;

import com.johnny.customerapi.domain.customer.Customer;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private static final String ADDRESS_SERVICE="addressService";
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;
    @Scheduled(cron = "0 * * * * *")
    public void updateCustomerAddress(){
        if(circuitBreakerRegistry.circuitBreaker(ADDRESS_SERVICE).getState() == CircuitBreaker.State.CLOSED){
            System.out.println("Start update Customer ");
            List<Customer> customers = customerService.getCustomersWithoutAddress();
            for (Customer customer : customers) {
                Customer customerUpdated = addressService.updateAddress(customer);
                customerService.save(customerUpdated);
                System.out.println("Customer updated: " + customerUpdated.getName());
            }
            System.out.println("Finish update Customer ");
        }else{
            System.out.println("Circuit break not closed");
        }
    }
}
