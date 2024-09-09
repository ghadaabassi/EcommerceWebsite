package com.micro.orderservice.entities.Product;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(
        name="product-Service",
        url = "${application.config.product-url}"
)
public interface IProduct {
    @PostMapping("/getProductById/{id}")
    ResponseEntity<ProductResponse> findById( @PathVariable("id") Integer productId );

}
