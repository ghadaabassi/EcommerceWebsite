package com.micro.orderservice.entities.Order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.micro.orderservice.enums.PaymentMethod;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record OrderResponse(
        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod payementMethod,
        Long customerId
) {
}
