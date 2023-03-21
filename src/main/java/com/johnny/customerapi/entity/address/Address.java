package com.johnny.customerapi.entity.address;

public class Address {
    private String street;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String number;
    private String complement;

    public Address(AddressDTO addressDTO) {
        this.street = addressDTO.street();
        this.neighborhood = addressDTO.neighborhood();
        this.zipcode = addressDTO.zipcode();
        this.city = addressDTO.city();
        this.state = addressDTO.state();
        this.number = addressDTO.number();
        this.complement = addressDTO.complement();
    }
}