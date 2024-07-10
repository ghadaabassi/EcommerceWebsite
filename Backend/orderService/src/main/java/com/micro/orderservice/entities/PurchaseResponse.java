package com.micro.orderservice.entities;

import java.math.BigDecimal;

public record PurchaseResponse(
        Integer id,
        String name,

        String description,
        BigDecimal price,

        double qt
) {
}
