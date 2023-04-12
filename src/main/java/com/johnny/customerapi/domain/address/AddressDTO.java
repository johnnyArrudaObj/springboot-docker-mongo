package com.johnny.customerapi.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
        String street,
        String neighborhood,
        @NotBlank(message = "Zipcode cannot be null")
        @Pattern(regexp = "\\d{8}", message = "Invalid ZipCode")
        String zipcode,
        String city,
        String state,
        String complement) {
}
