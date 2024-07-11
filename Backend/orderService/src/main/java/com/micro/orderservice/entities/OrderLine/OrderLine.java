package com.micro.orderservice.entities.OrderLine;

import com.micro.orderservice.entities.Order.Order;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    private int productid;

    private double quantity;

}
