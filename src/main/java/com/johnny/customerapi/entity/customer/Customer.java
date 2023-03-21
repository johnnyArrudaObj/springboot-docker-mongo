package com.johnny.customerapi.entity;

import com.johnny.customerapi.entity.address.Address;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("customer")
public class Customer {
    @Id
    private Integer id;
    private String name;
    private String cpf;
    private Specialty specialty;
    private Address address;
}
