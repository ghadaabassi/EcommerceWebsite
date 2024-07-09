package com.micro.orderservice.entities;


import com.micro.orderservice.enums.PayementMethod;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
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
    private Long id;
    private String reference;
    private String customerId;

    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private PayementMethod payementMethod;

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false)

    private LocalDateTime lastModified;

}

