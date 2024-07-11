package com.micro.orderservice.entities.Product;

import com.micro.orderservice.entities.Purchase.PurchaseRequest;
import com.micro.orderservice.entities.Purchase.PurchaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name="productService",
        url = "${application.config.product-url}"
)
public interface IProductClient {

    @PostMapping("/purchase")
    ResponseEntity<List<PurchaseResponse>> purchaseProducts(@RequestBody List<PurchaseRequest> request);


}
