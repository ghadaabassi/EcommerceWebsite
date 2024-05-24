package com.micro.orderservice.messaging;

import com.micro.orderservice.entities.Order;
import com.micro.orderservice.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {

    @Autowired
    private IOrderRepository orderRepository;

    @KafkaListener(topics = "product-events")
    public void consumeProductEvent(Order order) {

        orderRepository.save(order);
    }
}

