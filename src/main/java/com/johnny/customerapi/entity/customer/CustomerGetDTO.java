package com.johnny.customerapi.entity.customer;

import com.johnny.customerapi.entity.address.Address;
import com.johnny.customerapi.entity.specialty.Specialty;

public record CustomerGetDTO(String id, String name, Specialty specialty, Address address) {

    public CustomerGetDTO(Customer customer){
        this(customer.getId(), customer.getName(), customer.getSpecialty(), customer.getAddress());
    }
}
