package com.johnny.customerapi.domain.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("address")
public class Address {
    private String street;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String complement;

    public Address(AddressDTO addressDTO) {
        this.street = addressDTO.street();
        this.neighborhood = addressDTO.neighborhood();
        this.zipcode = addressDTO.zipcode();
        this.city = addressDTO.city();
        this.state = addressDTO.state();
        this.complement = addressDTO.complement();
    }

    public void updateData(AddressDTO addressDTO) {
        if (addressDTO.street()  != null) {
            this.street = addressDTO.street();
        }
        if (addressDTO.neighborhood()  != null) {
            this.neighborhood = addressDTO.neighborhood();
        }
        if (addressDTO.zipcode()  != null) {
            this.zipcode = addressDTO.zipcode();
        }
        if (addressDTO.city()  != null) {
            this.city = addressDTO.city();
        }
        if (addressDTO.state()  != null) {
            this.state = addressDTO.state();
        }
        if (addressDTO.complement()  != null) {
            this.complement = addressDTO.complement();
        }
    }
}
