package com.micro.productservice.services;


import com.micro.productservice.controllers.ProductPurchaseResponse;
import com.micro.productservice.controllers.ProductRequest;
import com.micro.productservice.controllers.ProductResponse;
import com.micro.productservice.entities.File;
import com.micro.productservice.entities.Product;
import com.micro.productservice.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService{


    private final IProductRepository productRepository;
    private final ProductMapper productMapper;


@Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::fromProduct)
                .collect(Collectors.toList());
    }

    @Override
    public Product addImageProduct(int id, File file) {
      Product pr = productRepository.findById(id).orElse(null);

        if (pr != null) {
            pr.setFile(file);
            return productRepository.save(pr);
        }
       return null;
    }


    @Override
    public ProductResponse findById(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::fromProduct)
                .orElse(null);
    }

    @Override
    public Integer createProduct(
            ProductRequest request
    ) {
        var product = productMapper.toProduct(request);
        return productRepository.save(product).getId();
    }

}
