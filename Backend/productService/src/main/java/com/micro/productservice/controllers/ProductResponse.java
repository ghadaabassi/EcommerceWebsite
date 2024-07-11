package com.micro.productservice.controllers;

import com.micro.productservice.enums.Category;

import java.math.BigDecimal;

public record ProductResponse(
       int id,
       String name,
       String description,
       String fileName,
       String fileData,
       Category category,
       double qt,
       BigDecimal price

) {
}
