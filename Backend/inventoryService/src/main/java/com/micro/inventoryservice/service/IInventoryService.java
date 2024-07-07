package com.micro.inventoryservice.service;

import com.micro.inventoryservice.entities.Inventory;
import com.micro.orderservice.entities.Order;
import com.micro.productservice.entities.Product;

import java.util.List;

public interface IInventoryService {
    public void updateInventory(Order order);
    public void deleteOrder(Long orderId);

    public Inventory addProductInventory(Long id, Product product);

    public Inventory addInventory(Inventory inventory);

    public List<Inventory> getAllInventories();

    public Inventory getInventoryById(Long Id);

    public boolean deleteInventoryByProductId(Long productid);



}
