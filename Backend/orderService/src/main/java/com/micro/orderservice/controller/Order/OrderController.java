package com.micro.orderservice.controller.Order;



import com.micro.orderservice.entities.Order.Order;
import com.micro.orderservice.entities.Order.OrderRequest;
import com.micro.orderservice.entities.Order.OrderResponse;
import com.micro.orderservice.repository.Order.IOrderRepository;
import com.micro.orderservice.service.Order.IOrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class OrderController {

    private IOrderService orderService;

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderResponse>> findAll() {
        return ResponseEntity.ok(this.orderService.findAllOrders());
    }

    @GetMapping("getAllOrders/{order-id}")
    public ResponseEntity<OrderResponse> findById(
            @PathVariable("order-id") Integer orderId
    ) {
        return ResponseEntity.ok(this.orderService.findById(orderId));
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Integer> createOrder(@RequestBody  @Valid OrderRequest orderRequest) {

        return ResponseEntity.ok(orderService.addOrder(orderRequest));
    }


}
