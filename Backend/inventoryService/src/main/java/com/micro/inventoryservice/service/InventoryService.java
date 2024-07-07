package com.micro.inventoryservice.service;

import com.micro.inventoryservice.entities.Inventory;
import com.micro.inventoryservice.repository.IInventoryRepository;
import com.micro.orderservice.entities.Order;
import com.micro.orderservice.repository.IOrderRepository;
import com.micro.productservice.entities.Product;
import com.micro.productservice.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class InventoryService implements IInventoryService{

    private IProductRepository productRepository;
    private IOrderRepository orderRepository;
    private IInventoryRepository inventoryRepository;

    @Override
    @CrossOrigin(origins = "*")
    public void updateInventory(Order order) {
        Long productId = order.getProductId();
        int quantity = order.getQuantity();

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        Inventory inventory = inventoryRepository.findByProduct(product)
                .orElse(new Inventory());

        int updatedStock = (inventory.getQuantity() - quantity);
        if (updatedStock < 0) {
            throw new RuntimeException("Insufficient stock for product: " + product.getName());
        }

        inventory.setQuantity(updatedStock);
        inventoryRepository.save(inventory);
    }

    @Override

    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        Long productId = order.getProductId();
        Product product = productRepository.findById(productId).orElse(null);

        Inventory inventory = inventoryRepository.findByProduct(product)
                .orElse(new Inventory());
        int productQt = inventory.getQuantity();
        int newQt=  (productQt + order.getQuantity());
        inventory.setQuantity(newQt);
        inventoryRepository.save(inventory);

        System.out.println(product);
        System.out.println(inventory);
        orderRepository.deleteById(orderId);
    }

    @Override
    public Inventory addProductInventory(Long id, Product product) {

        Inventory inv = inventoryRepository.findById(id).orElse(null);
        inv.setProduct(product);
        return inventoryRepository.save(inv);
    }

    @Override
    public Inventory addInventory(Inventory inventory) {

        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }
    @Override
    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteInventoryByProductId(Long productId) {
        Product p = productRepository.findById(productId).orElse(null);
        System.out.println("Hello world !");
        Optional<Inventory> inventoryOptional = inventoryRepository.findByProduct(p);
        if (inventoryOptional.isPresent()) {
            inventoryRepository.delete(inventoryOptional.get());
            return true;
        }
        return false;
    }


}

