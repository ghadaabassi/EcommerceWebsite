package com.micro.productservice.services;



import com.micro.productservice.controllers.ProductRequest;
import com.micro.productservice.entities.Product;
import com.micro.productservice.controllers.ProductResponse;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        if (request==null){
            return null;
        }
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .category(request.category())
                .qt(request.qt())
                .price(request.price())
                .build();

    }


    public ProductResponse fromProduct(Product product){
        String fileName = null;
        String fileData = null;

        if (product.getFile() != null) {
            fileName = product.getFile().getFileName();
            fileData = Base64.getEncoder().encodeToString(product.getFile().getData());
        }
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                fileName,
                fileData,
                product.getCategory(),
                product.getQt(),
                product.getPrice()
        );
    }



}
