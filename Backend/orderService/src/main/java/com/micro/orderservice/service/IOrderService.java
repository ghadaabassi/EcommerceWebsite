package com.micro.orderservice.service;

import com.micro.orderservice.entities.Order;
import com.micro.orderservice.entities.OrderRequest;

public interface IOrderService {


    public String deleteOrder(Long id);

    Order addOrder(OrderRequest orderRequest);
}
