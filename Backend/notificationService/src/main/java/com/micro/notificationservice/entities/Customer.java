package com.micro.notificationservice.entities;

public record Customer(
        String id,
        String firstname,
        String lastname,
        String email
) {

}
