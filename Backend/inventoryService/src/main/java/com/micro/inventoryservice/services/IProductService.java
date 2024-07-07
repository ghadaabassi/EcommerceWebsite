package com.micro.productservice.services;

import com.micro.productservice.entities.File;
import com.micro.productservice.entities.Product;

import java.util.List;

public interface IProductService {

    public Product addImageProduct(Long id, File file);
}
