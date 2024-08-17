package com.micro.orderservice.controller.OrderLine;


import com.micro.orderservice.entities.OrderLine.OrderLineResponse;
import com.micro.orderservice.service.OrderLine.IOrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class OrderLineController {

    private final IOrderLineService orderLineService;

    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderLineResponse>> findByOrderId(
            @PathVariable("order-id") Integer orderId
    ) {
        return ResponseEntity.ok(orderLineService.findAllByOrderId(orderId));
    }
}