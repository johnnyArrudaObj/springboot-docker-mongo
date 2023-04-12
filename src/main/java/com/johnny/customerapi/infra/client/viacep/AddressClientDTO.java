package com.johnny.customerapi.infra.client.viacep;

public record AddressClientDTO(
        String logradouro,
        String bairro,
        String cep,
        String localidade,
        String uf
) {
}
