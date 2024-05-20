package com.micro.inventoryservice.messaging;



import com.micro.orderservice.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class InventoryEventProducer {

    private static final String TOPIC = "order-events";

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void sendOrderEvent(Order order) {
        kafkaTemplate.send(TOPIC, order);
    }
}

