package com.micro.orderservice.repository.OrderLine;

import com.micro.orderservice.entities.OrderLine.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderLineRepository extends JpaRepository<OrderLine, Integer> {

    List<OrderLine> findAllByOrderId(Integer orderId);
}
