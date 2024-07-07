package com.micro.productservice.entities;


import com.micro.productservice.enums.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private double price;
    private String fileName;
    private String fileData;
    private Category category;

}
