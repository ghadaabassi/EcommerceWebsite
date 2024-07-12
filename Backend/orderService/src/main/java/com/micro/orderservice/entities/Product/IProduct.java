package com.micro.orderservice.entities.Product;

import com.micro.orderservice.entities.Purchase.ProductPurchaseRequest;
import com.micro.orderservice.entities.Purchase.ProductPurchaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name="product-Service",
        url = "${application.config.product-url}"
)
public interface IProduct {

    @PostMapping("/purchase")
    ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(@RequestBody List<ProductPurchaseRequest> request);


}
