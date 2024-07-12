package com.micro.orderservice.kafka;

import com.micro.orderservice.entities.Customer.CustomerResponse;
import com.micro.orderservice.entities.Purchase.ProductPurchaseResponse;
import com.micro.orderservice.enums.PayementMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PayementMethod paymentMethod,
        CustomerResponse customer,
        List<ProductPurchaseResponse> products

) {
}
