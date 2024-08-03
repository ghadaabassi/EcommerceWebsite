package com.micro.notificationservice.entities;

import com.micro.notificationservice.enums.NotificationType;
import com.micro.notificationservice.kafka.OrderConfirmation;
import com.micro.notificationservice.kafka.PaymentConfirmation;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    private LocalDateTime notificationDate;

    @Embedded
    private OrderConfirmation orderConfirmation;

    @Embedded
    private PaymentConfirmation paymentConfirmation;
}