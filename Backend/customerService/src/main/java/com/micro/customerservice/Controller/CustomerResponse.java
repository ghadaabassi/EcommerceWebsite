package com.micro.customerservice.Controller;

import com.micro.customerservice.entities.Adress;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerResponse(
        Long id,

        String firstname,

        String lastname,

        String email,
        Adress address) {
}
