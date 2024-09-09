package com.micro.orderservice.entities.Order;



import com.micro.orderservice.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity(name = "`order`")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reference;
    private Long customerId;

    private BigDecimal totalAmount;

    @ElementCollection
    private List<Integer> myProducts;


    @Enumerated(EnumType.STRING)
    private PaymentMethod payementMethod;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false)

    private LocalDateTime lastModified;




}

