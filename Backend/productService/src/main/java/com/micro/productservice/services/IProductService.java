package com.micro.productservice.services;

import com.micro.productservice.controllers.ProductPurchaseRequest;
import com.micro.productservice.controllers.ProductPurchaseResponse;
import com.micro.productservice.controllers.ProductRequest;
import com.micro.productservice.controllers.ProductResponse;
import com.micro.productservice.entities.File;
import com.micro.productservice.entities.Product;

import java.util.List;

public interface IProductService {

    public Product addImageProduct(int id, File file);



    List<ProductResponse> getAllProducts();

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);

    ProductResponse findById(Integer productId);

    Integer createProduct(ProductRequest request);
}
