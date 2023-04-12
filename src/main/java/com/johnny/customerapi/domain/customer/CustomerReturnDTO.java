package com.johnny.customerapi.domain.customer;

import com.johnny.customerapi.domain.address.Address;
import com.johnny.customerapi.domain.specialty.Specialty;

public record CustomerReturnDTO(String id, String name, String cpf, Specialty specialty, Address address) {
    public CustomerReturnDTO(Customer customer){
        this(customer.getId(), customer.getName(), customer.getCpf(), customer.getSpecialty(), customer.getAddress());
    }
}
