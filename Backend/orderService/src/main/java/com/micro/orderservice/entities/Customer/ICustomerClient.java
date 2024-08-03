package com.micro.orderservice.entities.Customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name="customerService",
        url = "${application.config.customer-url}"
)
public interface ICustomerClient {

@GetMapping("/findCustomer/{id}")
    Optional<CustomerResponse> findCustomerById(@PathVariable("id") Long id );

}
