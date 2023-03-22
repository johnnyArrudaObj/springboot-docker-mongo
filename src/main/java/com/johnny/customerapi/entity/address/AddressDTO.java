package com.johnny.customerapi.entity.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
        @NotBlank(message = "Street cannot be null")
        String street,
        @NotBlank(message = "Neighborhood cannot be null")
        String neighborhood,
        @NotBlank(message = "Zipcode cannot be null")
        @Pattern(regexp = "\\d{8}")
        String zipcode,
        @NotBlank(message = "City cannot be null")
        String city,
        @NotBlank(message = "State cannot be null")
        String state,
        @NotBlank(message = "Number cannot be null")
        String number,
        String complement) {
}
