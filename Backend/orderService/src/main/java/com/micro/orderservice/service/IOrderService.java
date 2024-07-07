package com.micro.orderservice.service;

import com.micro.orderservice.entities.Order;

public interface IOrderService {
    public void processOrder(Order order);

    public String deleteOrder(Long id);
}
