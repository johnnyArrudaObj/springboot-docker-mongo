package com.johnny.customerapi.domain.customer;

import com.johnny.customerapi.domain.address.Address;
import com.johnny.customerapi.domain.address.AddressDTO;
import com.johnny.customerapi.domain.specialty.Specialty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CustomerDTO(
        @NotBlank(message = "Name cannot be null")
        String name,
        @NotBlank(message = "Cpf cannot be null")
        @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}", message = "Invalid Cpf")
        String cpf,
        @NotNull(message = "Specialty cannot be null")
        Specialty specialty,
        @NotNull(message = "Address cannot be null")
        @Valid
        AddressDTO address) {
}
