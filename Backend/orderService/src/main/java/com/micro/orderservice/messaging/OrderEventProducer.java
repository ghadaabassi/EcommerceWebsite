package com.micro.orderservice.messaging;



import com.micro.orderservice.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventProducer {

    private  String TOPIC = "order-events";

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void sendOrderEvent(Order order) {

        kafkaTemplate.send((String)TOPIC,order);
    }
}
