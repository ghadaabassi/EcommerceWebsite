package com.micro.customerservice.Controller;

import com.micro.customerservice.entities.Adress;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest (
    Long id,
    @NotNull(message = "Customer firstname is required")
    String firstname,
    @NotNull(message = "Customer lastname is required")
    String lastname,
    @NotNull(message = "Customer email is required")
    @Email(message = "Customer email is not valid")
    String email,
    Adress address
){

}
