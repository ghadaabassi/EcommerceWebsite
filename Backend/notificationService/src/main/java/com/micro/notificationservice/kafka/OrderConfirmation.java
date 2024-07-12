package com.micro.notificationservice.kafka;

import com.micro.notificationservice.entities.Customer;
import com.micro.notificationservice.entities.Product;
import com.micro.notificationservice.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products

) {
}