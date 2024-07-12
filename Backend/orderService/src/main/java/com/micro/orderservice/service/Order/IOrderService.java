package com.micro.orderservice.service.Order;

import com.micro.orderservice.entities.Order.Order;
import com.micro.orderservice.entities.Order.OrderRequest;

public interface IOrderService {


    public String deleteOrder(int id);

    Integer addOrder(OrderRequest orderRequest);
}
