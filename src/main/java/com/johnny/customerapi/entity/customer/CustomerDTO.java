package com.johnny.customerapi.entity.customer;

import com.johnny.customerapi.entity.address.AddressDTO;
import com.johnny.customerapi.entity.specialty.Specialty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CustomerDTO(
        @NotBlank(message = "Name cannot be null")
        String name,
        @NotBlank(message = "Cpf cannot be null")
        @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}")
        String cpf,
        @NotNull(message = "Specialty cannot be null")
        Specialty specialty,
        @NotNull(message = "Address cannot be null")
        @Valid
        AddressDTO address) {
}
