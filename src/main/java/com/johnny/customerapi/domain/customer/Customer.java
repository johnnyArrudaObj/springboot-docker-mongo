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
    @Indexed(unique=true)
    private String name;
    @Indexed(unique = true)
    private String cpf;
    private Specialty specialty;
    private Address address;

    public Customer(CustomerDTO customerDto) {
        this.name = customerDto.name();
        this.cpf = customerDto.cpf();
        this.specialty = customerDto.specialty();
        this.address = new Address(customerDto.address());
    }
}
