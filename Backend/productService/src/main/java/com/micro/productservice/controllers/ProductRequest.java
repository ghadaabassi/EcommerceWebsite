package com.micro.productservice.controllers;

import com.micro.productservice.enums.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(

        Integer id,
        @NotNull(message = "Product name is required")
        String name,
        @NotNull(message = "Product description is required")
        String description,
        @NotNull(message = "Product category is required")
        Category category,
        @Positive(message = "Available quantity should be positive")
        double qt,
        @Positive(message = "Price should be positive")
        BigDecimal price



) {
}