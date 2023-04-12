package com.johnny.customerapi.service;

import com.johnny.customerapi.domain.address.Address;
import com.johnny.customerapi.domain.customer.Customer;
import com.johnny.customerapi.infra.client.viacep.AddressClientDTO;
import com.johnny.customerapi.infra.client.viacep.ViacepClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressService {
    @Autowired
    private ViacepClient viacepClient;
    private static final String ADDRESS_SERVICE="addressService";

    @CircuitBreaker(name = ADDRESS_SERVICE, fallbackMethod = "returnCustomerWithoutAddress")
    public Customer updateAddress(Customer customer) {
        AddressClientDTO completeAddress = viacepClient.getAddress("1");
        Address address = new Address();
        address.setStreet(completeAddress.logradouro());
        address.setNeighborhood(completeAddress.bairro());
        address.setZipcode(completeAddress.cep());
        address.setCity(completeAddress.localidade());
        address.setState(completeAddress.uf());
        customer.setAddress(address);
        customer.setConfirmedAddress(true);
        return customer;
    }

    public Customer returnCustomerWithoutAddress(Customer customer, Exception exception) {
        Address address = new Address();
        address.setStreet("Default");
        address.setNeighborhood("Default");
        address.setZipcode("Default");
        address.setCity("Default");
        address.setState("Default");
        customer.setAddress(address);
        customer.setConfirmedAddress(false);
        return customer;
    }
}
