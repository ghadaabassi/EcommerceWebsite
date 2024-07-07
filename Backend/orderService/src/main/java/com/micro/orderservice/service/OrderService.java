package com.micro.orderservice.service;



import com.micro.orderservice.entities.Order;
import com.micro.orderservice.messaging.OrderEventProducer;
import com.micro.orderservice.repository.IOrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderService {

    private IOrderRepository orderRepository;

    private OrderEventProducer orderEventProducer;


    @Transactional
    public void processOrder(Order order) {
        Order savedOrder = orderRepository.save(order);

        orderEventProducer.sendOrderEvent(savedOrder);
    }

    public String deleteOrder(Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            orderEventProducer.sendOrderDeletedEvent(orderId);
        } else {
            throw new RuntimeException("Order not found with id: " + orderId);
        }


        return "Deleted with success !";
    }


}
