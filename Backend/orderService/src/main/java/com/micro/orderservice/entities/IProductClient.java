package com.micro.orderservice.entities;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name="productService",
        url = "${application.config.product-url}"
)
public interface IProductClient {

    @GetMapping("/findCustomer/{id}")
    Optional<CustomerResponse> findCustomerById(@PathVariable("id") String id );

}
