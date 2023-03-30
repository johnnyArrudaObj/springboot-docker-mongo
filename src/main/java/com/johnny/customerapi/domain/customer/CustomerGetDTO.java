package com.johnny.customerapi.domain.customer;

import com.johnny.customerapi.domain.address.Address;
import com.johnny.customerapi.domain.specialty.Specialty;

public record CustomerGetDTO(String id, String name, Specialty specialty, Address address) {

    public CustomerGetDTO(Customer customer){
        this(customer.getId(), customer.getName(), customer.getSpecialty(), customer.getAddress());
    }
}
