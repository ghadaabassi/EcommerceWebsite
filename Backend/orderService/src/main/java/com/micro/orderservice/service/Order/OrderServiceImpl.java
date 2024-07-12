package com.micro.orderservice.service.Order;



import com.micro.orderservice.controller.payment.PaymentClient;
import com.micro.orderservice.entities.Customer.ICustomerClient;
import com.micro.orderservice.entities.Order.OrderRequest;
import com.micro.orderservice.entities.Order.OrderResponse;
import com.micro.orderservice.entities.OrderLine.OrderLineRequest;
import com.micro.orderservice.entities.Product.IProduct;
import com.micro.orderservice.entities.Purchase.ProductPurchaseRequest;
import com.micro.orderservice.entities.payment.PaymentRequest;
import com.micro.orderservice.kafka.OrderConfirmation;
import com.micro.orderservice.kafka.OrderProducer;
import com.micro.orderservice.repository.Order.IOrderRepository;
import com.micro.orderservice.service.OrderLine.IOrderLineService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private IOrderRepository orderRepository;
    private ICustomerClient custommerClient;
    private IProduct productClient;
    private OrderMapper orderMapper;
    private IOrderLineService orderLineService;
    private OrderProducer orderProducer;

    private PaymentClient paymentClient;

    @Override
    public Integer addOrder(OrderRequest orderRequest) {


    var customer = custommerClient.findCustomerById(orderRequest.customerId())
            .orElseThrow(() -> new NoSuchElementException("Customer with ID " + orderRequest.customerId() + " not found"));

     var purchasedProducts= this.productClient.purchaseProducts(orderRequest.products());


        var order = this.orderRepository.save(orderMapper.toOrder(orderRequest));

       for(ProductPurchaseRequest purchaseRequest:orderRequest.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
       }


       var paymentRequest= new PaymentRequest(
              orderRequest.amount(),
              orderRequest.paymentMethod(),
               orderRequest.id(),
               orderRequest.reference(),
               customer

       );
       paymentClient.requestOrderPayment(paymentRequest);


       orderProducer.sendOrderConfirmation(
               new OrderConfirmation(
               orderRequest.reference(),
               orderRequest.amount(),
               orderRequest.paymentMethod(),
               customer,
               purchasedProducts.getBody())
       );

        return order.getId(); }


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
