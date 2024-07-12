package com.micro.orderservice.entities.payment;

import com.micro.orderservice.entities.Customer.CustomerResponse;
import com.micro.orderservice.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}