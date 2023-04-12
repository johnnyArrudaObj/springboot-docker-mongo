package com.johnny.customerapi.infra.client.viacep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface ViacepClient {

    @GetMapping("{zipcode}")
    AddressClientDTO getAddress(@PathVariable("zipcode") String zipcode);
}
