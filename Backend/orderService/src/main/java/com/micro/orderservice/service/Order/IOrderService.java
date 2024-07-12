package com.micro.orderservice.service.Order;

import com.micro.orderservice.entities.Order.Order;
import com.micro.orderservice.entities.Order.OrderRequest;
import com.micro.orderservice.entities.Order.OrderResponse;

import java.util.List;

public interface IOrderService {

    Integer addOrder(OrderRequest orderRequest);

    List<OrderResponse> findAllOrders();

    OrderResponse findById(Integer orderId);
}
