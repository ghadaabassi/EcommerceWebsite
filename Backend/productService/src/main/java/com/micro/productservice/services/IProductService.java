package com.micro.productservice.services;

import com.micro.productservice.entities.File;
import com.micro.productservice.entities.Product;

public interface IProductService {

    public Product addImageProduct(Long id, File file);
}
