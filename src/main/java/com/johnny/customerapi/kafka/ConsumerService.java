package com.johnny.customerapi.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnny.customerapi.domain.customer.Customer;
import com.johnny.customerapi.domain.customer.CustomerDTO;
import com.johnny.customerapi.service.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Log4j2
@Service
public class ConsumerService {
    @Autowired
    private CustomerService customerService;
    @KafkaListener(topics = "${topic.customer}", groupId = "group_id")
    public void consume(String messageString) throws IOException {
        log.info("Mensagem Customer {}", messageString);
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerDTO customer = objectMapper.readValue(messageString, CustomerDTO.class);
        var customerFinal = customerService.save(new Customer(customer));
        log.info("Customer saved: {}", customerFinal);
    }
}
