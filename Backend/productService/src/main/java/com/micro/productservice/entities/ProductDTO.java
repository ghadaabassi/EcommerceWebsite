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
    private String name;
    private String description;
    private String fileName;
    private String fileData;
    private Category category;
    private double qt;
    private BigDecimal price;



}
