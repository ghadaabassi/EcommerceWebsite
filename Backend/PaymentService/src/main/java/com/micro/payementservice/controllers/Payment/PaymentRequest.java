package com.micro.payementservice.controllers.Payment;

import com.micro.payementservice.controllers.customer.Customer;
import com.micro.payementservice.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
