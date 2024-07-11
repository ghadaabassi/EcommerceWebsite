package com.micro.productservice.services;


import com.micro.productservice.controllers.ProductPurchaseResponse;
import com.micro.productservice.controllers.ProductRequest;
import com.micro.productservice.entities.Product;
import com.micro.productservice.controllers.ProductResponse;
import com.micro.productservice.enums.Category;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Base64;

@Service
public class ProductMapper {

    public Product toProdut(ProductRequest request) {
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
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getFile().getFileName(),
                Base64.getEncoder().encodeToString(product.getFile().getData()),
                product.getCategory(),
                product.getQt(),
                product.getPrice()
        );
    }


    public ProductPurchaseResponse toproductPurchaseResponse(Product product, double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }

}
