package com.micro.orderservice.controller;



import com.micro.orderservice.entities.Order;
import com.micro.orderservice.entities.OrderRequest;
import com.micro.orderservice.repository.IOrderRepository;
import com.micro.orderservice.service.IOrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class OrderController {


    private IOrderRepository orderRepository;
    private IOrderService orderService;


    @GetMapping("/getAll")
    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    @GetMapping("getOrder/{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        //List<Order> order = orderRepository.findById(id);
        return orderRepository.findById(id).orElse(null);
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Order> createOrder(@RequestBody  @Valid OrderRequest orderRequest) {

        return ResponseEntity.ok(orderService.addOrder(orderRequest));
    }

    @PutMapping("updateOrder/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        order.setId(id);
        Order updatedOrder = orderRepository.save(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("deleteOrder/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
