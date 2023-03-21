package com.johnny.customerapi.entity.address;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record AddressDTO(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zipcode,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        String number,
        String complement) {
}
