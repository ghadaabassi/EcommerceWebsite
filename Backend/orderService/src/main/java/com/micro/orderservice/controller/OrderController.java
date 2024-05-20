package com.micro.orderservice.controller;



import com.micro.orderservice.entities.Order;
import com.micro.orderservice.messaging.OrderEventProducer;
import com.micro.orderservice.repository.IOrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")

public class OrderController {

    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private OrderEventProducer orderEventProducer;

    @GetMapping
    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        //List<Order> order = orderRepository.findById(id);
        return orderRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Transactional
    public Order createOrder(@RequestBody Order order) {

        Order savedOrder = orderRepository.save(order);

        orderEventProducer.sendOrderEvent(savedOrder);
        return savedOrder;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        order.setId(id);
        Order updatedOrder = orderRepository.save(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
