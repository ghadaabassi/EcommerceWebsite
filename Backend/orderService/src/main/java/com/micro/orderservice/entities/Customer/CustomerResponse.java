package com.micro.orderservice.entities.Customer;

public record CustomerResponse(

        String id,
        String firstname,
        String lastname,
        String email

) {
}
