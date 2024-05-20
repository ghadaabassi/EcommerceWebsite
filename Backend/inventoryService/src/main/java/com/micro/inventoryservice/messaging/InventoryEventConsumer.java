package com.micro.inventoryservice.messaging;


import com.micro.inventoryservice.entities.Inventory;
import com.micro.inventoryservice.service.InventoryService;
import com.micro.orderservice.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class InventoryEventConsumer {

    @Autowired
    private InventoryService inventoryService;

    @KafkaListener(topics = "order-events")
    public void consumeOrderEvent(Order order) {
        System.out.println("Consumed Order: " + order);
        inventoryService.updateInventory(order);
    }

}
