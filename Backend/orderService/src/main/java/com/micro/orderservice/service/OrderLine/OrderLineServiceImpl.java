package com.micro.orderservice.service.OrderLine;

import com.micro.orderservice.entities.OrderLine.OrderLineRequest;
import com.micro.orderservice.entities.OrderLine.OrderLineResponse;
import com.micro.orderservice.repository.OrderLine.IOrderLineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderLineServiceImpl implements IOrderLineService{

    private final IOrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    @Override
    public Integer saveOrderLine(OrderLineRequest request) {
        var order = orderLineMapper.toOrderLine(request);
        return orderLineRepository.save(order).getId();
    }
@Override
    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return orderLineRepository.findAllByOrderId(orderId)
                .stream()
                .map(orderLineMapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
