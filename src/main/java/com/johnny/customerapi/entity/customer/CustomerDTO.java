package com.johnny.customerapi.entity.customer;

import com.johnny.customerapi.entity.specialty.Specialty;
import com.johnny.customerapi.entity.address.AddressDTO;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record CustomerDTO(
        @NotBlank
        String name,
        @NotBlank
        @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}")
        String cpf,
        @NotNull
        Specialty specialty,
        @NotNull
        @Valid
        AddressDTO address) {
}
