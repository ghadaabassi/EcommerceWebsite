package com.micro.orderservice.entities.Purchase;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
        Integer id,
        String name,
        String description,
        BigDecimal price,

        double qt
) {
}
