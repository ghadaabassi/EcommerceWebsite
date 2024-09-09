package com.micro.orderservice.kafka;

import com.micro.orderservice.entities.Customer.CustomerResponse;
import com.micro.orderservice.enums.PaymentMethod;

import java.math.BigDecimal;


public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer


) {
}
