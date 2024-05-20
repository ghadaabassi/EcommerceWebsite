package com.micro.productservice.messaging;


import com.micro.productservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductEventProducer {

    private static final String TOPIC = "product-events";

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    public void sendProductEvent(Product product) {
        kafkaTemplate.send(TOPIC, product);
    }
}

