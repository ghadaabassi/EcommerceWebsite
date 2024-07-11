package com.micro.orderservice.service.Order;



import com.micro.orderservice.entities.Customer.ICustomerClient;
import com.micro.orderservice.entities.Order.Order;
import com.micro.orderservice.entities.Order.OrderRequest;
import com.micro.orderservice.entities.OrderLine.OrderLineRequest;
import com.micro.orderservice.entities.Product.IProductClient;
import com.micro.orderservice.entities.Purchase.PurchaseRequest;
import com.micro.orderservice.repository.Order.IOrderRepository;
import com.micro.orderservice.service.OrderLine.OrderLineService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private IOrderRepository orderRepository;
    private ICustomerClient custommerClient;
    private IProductClient productClient;
    private OrderMapper orderMapper;
    private OrderLineService orderLineService;



    public String deleteOrder(Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        } else {
            throw new RuntimeException("Order not found with id: " + orderId);
        }


        return "Deleted with success !";
    }



    @Override
    public Order addOrder(OrderRequest orderRequest) {



    var customer = custommerClient.findCustomerById(orderRequest.customerId())
            .orElseThrow(() -> new NoSuchElementException("Customer with ID " + orderRequest.customerId() + " not found"));

     this.productClient.purchaseProducts(orderRequest.products());


        var order = this.orderRepository.save(orderMapper.toOrder(orderRequest));

       for(PurchaseRequest purchaseRequest:orderRequest.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()

                    )
            );
       }

        return null;}


}
