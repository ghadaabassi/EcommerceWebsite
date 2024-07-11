package com.micro.orderservice.service.OrderLine;

import com.micro.orderservice.entities.Order.Order;
import com.micro.orderservice.entities.OrderLine.OrderLine;
import com.micro.orderservice.entities.OrderLine.OrderLineRequest;
import com.micro.orderservice.entities.OrderLine.OrderLineResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.orderId())
                .productid(request.productId())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .quantity(request.quantity())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
