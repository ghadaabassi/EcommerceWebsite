package com.micro.notificationservice.kafka;

import com.micro.notificationservice.enums.PaymentMethod;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public record PaymentConfirmation(
        String orderReferencePayment,
        BigDecimal amountPayment,
        PaymentMethod paymentMethodPayment,
        String customerFirstnamePayment,
        String customerLastnamePayment,
        String customerEmailPayment
) {
}