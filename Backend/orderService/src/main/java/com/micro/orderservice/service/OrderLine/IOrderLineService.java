package com.micro.orderservice.service.OrderLine;

import com.micro.orderservice.entities.OrderLine.OrderLineRequest;
import com.micro.orderservice.entities.OrderLine.OrderLineResponse;

import java.util.List;

public interface IOrderLineService {
    List<OrderLineResponse> findAllByOrderId(Integer orderId);

    Integer saveOrderLine(OrderLineRequest orderLineRequest);
}
