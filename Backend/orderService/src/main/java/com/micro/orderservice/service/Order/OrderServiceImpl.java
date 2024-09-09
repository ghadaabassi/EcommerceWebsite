package com.micro.orderservice.service.Order;



import com.micro.orderservice.controller.payment.PaymentClient;
import com.micro.orderservice.entities.Customer.ICustomerClient;
import com.micro.orderservice.entities.Order.OrderRequest;
import com.micro.orderservice.entities.Order.OrderResponse;
import com.micro.orderservice.entities.Product.IProduct;
import com.micro.orderservice.entities.payment.PaymentRequest;
import com.micro.orderservice.kafka.OrderConfirmation;
import com.micro.orderservice.kafka.OrderProducer;
import com.micro.orderservice.repository.Order.IOrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private IOrderRepository orderRepository;
    private ICustomerClient customerClient;
    private OrderMapper orderMapper;
    private OrderProducer orderProducer;


    @Override
    public Integer addOrder(OrderRequest orderRequest) {


    var customer = customerClient.findCustomerById(orderRequest.customerId())
            .orElseThrow(() -> new NoSuchElementException("Customer with ID " + orderRequest.customerId() + " not found"));



       var paymentRequest= new PaymentRequest(
              orderRequest.amount(),
              orderRequest.paymentMethod(),
               orderRequest.id(),
               orderRequest.reference(),
               customer

       );


     //  paymentClient.requestOrderPayment(paymentRequest);


       orderProducer.sendOrderConfirmation(
               new OrderConfirmation(
               orderRequest.reference(),
               orderRequest.amount(),
               orderRequest.paymentMethod(),
               customer
       ));

        return orderRequest.id(); }


@Override
    public List<OrderResponse> findAllOrders() {
        return this.orderRepository.findAll()
                .stream()
                .map(this.orderMapper::fromOrder)
                .collect(Collectors.toList());
    }
@Override
    public OrderResponse findById(Integer id) {
        return this.orderRepository.findById(id)
                .map(this.orderMapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: %d", id)));
    }


}
