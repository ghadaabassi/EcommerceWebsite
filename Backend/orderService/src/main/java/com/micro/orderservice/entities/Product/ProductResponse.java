package com.micro.orderservice.entities.Product;



import com.micro.orderservice.enums.Category;

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
