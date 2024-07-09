package com.micro.productservice.entities;


import com.micro.productservice.enums.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class ProductDTO {

    private int id;
    @NotNull(message="Product name is required")
    private String name;
    @NotNull(message="Product description is required")
    private String description;
    private String fileName;
    private String fileData;
    @NotNull(message="Product category is required")
    private Category category;
    @Positive(message="Quantity should be positive")
    private double qt;
    @Positive(message="Price should be positive")
    private BigDecimal price;



}
