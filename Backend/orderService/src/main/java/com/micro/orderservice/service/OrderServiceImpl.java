package com.micro.orderservice.service;



import com.micro.orderservice.entities.ICustomerClient;
import com.micro.orderservice.entities.IProductClient;
import com.micro.orderservice.entities.Order;
import com.micro.orderservice.entities.OrderRequest;
import com.micro.orderservice.repository.IOrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderServiceImpl implements IOrderService{

    private IOrderRepository orderRepository;
    private ICustomerClient custommerClient;
    private IProductClient productClient;



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



    var customer = custommerClient.findCustomerById(orderRequest.customerId()).orElse(null);

return null;

    }


}
