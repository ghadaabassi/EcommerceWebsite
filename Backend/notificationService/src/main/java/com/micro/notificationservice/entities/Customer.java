package com.micro.notificationservice.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public record Customer(
        String idCustomer,
        String firstname,
        String lastname,
        String email
) {

}
