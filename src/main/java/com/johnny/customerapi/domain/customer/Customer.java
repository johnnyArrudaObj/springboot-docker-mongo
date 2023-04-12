package com.johnny.customerapi.domain.customer;

import com.johnny.customerapi.domain.specialty.Specialty;
import com.johnny.customerapi.domain.address.Address;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("customer")
public class Customer {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String cpf;
    private Specialty specialty;
    private Boolean confirmedAddress;
    private Address address;

    public Customer(CustomerDTO customerDto) {
        this.name = customerDto.name();
        this.cpf = customerDto.cpf();
        this.specialty = customerDto.specialty();
        this.confirmedAddress = false;
        this.address = new Address(customerDto.address());
    }

    public void updateData(CustomerUpdateDTO customerUpdateDTO) {
        if (customerUpdateDTO.name()  != null) {
            this.name = customerUpdateDTO.name();
        }
        if (customerUpdateDTO.cpf()  != null) {
            this.cpf = customerUpdateDTO.cpf();
        }
        if (customerUpdateDTO.specialty()  != null) {
            this.specialty = customerUpdateDTO.specialty();
        }
        if (customerUpdateDTO.address()  != null) {
            this.address.updateData(customerUpdateDTO.address());
        }
    }
}
