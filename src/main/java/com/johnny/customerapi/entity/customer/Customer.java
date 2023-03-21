package com.johnny.customerapi.entity.customer;

import com.johnny.customerapi.entity.specialty.Specialty;
import com.johnny.customerapi.entity.address.Address;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Document("customer")
public class Customer {
    @Id
    private Integer id;
    private String name;
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
