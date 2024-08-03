package com.micro.notificationservice.kafka;

import com.micro.notificationservice.entities.Customer;
import com.micro.notificationservice.entities.Product;
import com.micro.notificationservice.enums.PaymentMethod;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.util.List;
@Embeddable
public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        @ElementCollection
        List<Product> products

) {
}