package com.micro.productservice.services;

import com.micro.productservice.entities.File;
import com.micro.productservice.entities.Product;
import com.micro.productservice.entities.ProductRequest;

public interface IProductService {

    public Product addImageProduct(int id, File file);

    Integer createProduct(ProductRequest request);
}
