package com.micro.inventoryservice.service;

import com.micro.orderservice.repository.IOrderRepository;
import com.micro.productservice.entities.Product;
import com.micro.productservice.repository.IProductRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.micro.orderservice.entities.Order;

@Service
@AllArgsConstructor
public class InventoryService {


    private IProductRepository productRepository;



    public void updateInventory(Order order) {
        Long productId = order.getProductId();
        int quantity = order.getQuantity();

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        int updatedStock = product.getQuantity() - quantity;
        if (updatedStock < 0) {
            throw new RuntimeException("Insufficient stock for product: " + product.getName());
        }
        product.setQuantity(updatedStock);

        productRepository.save(product);
    }

}

