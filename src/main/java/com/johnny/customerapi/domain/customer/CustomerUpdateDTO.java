package com.johnny.customerapi.domain.customer;

import com.johnny.customerapi.domain.address.AddressDTO;
import com.johnny.customerapi.domain.specialty.Specialty;

public record CustomerUpdateDTO(
        String name,
        String cpf,
        Specialty specialty,
        AddressDTO address) {
}
