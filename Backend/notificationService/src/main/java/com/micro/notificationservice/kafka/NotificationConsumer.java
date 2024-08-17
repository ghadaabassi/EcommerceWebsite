package com.micro.notificationservice.kafka;

import com.micro.notificationservice.entities.Notification;
import com.micro.notificationservice.repositories.INotificationRepository;
import com.micro.notificationservice.services.IEmailService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.micro.notificationservice.enums.NotificationType.ORDER_CONFIRMATION;
import static com.micro.notificationservice.enums.NotificationType.PAYMENT_CONFIRMATION;
import static java.lang.String.format;

@Service
@Slf4j
@AllArgsConstructor
public class NotificationConsumer {

    private INotificationRepository repository;
    private IEmailService emailService;
    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotifications(PaymentConfirmation paymentConfirmation) throws MessagingException {
        System.out.println("\n\n\nSent Tooooooooooooo1111 :"+paymentConfirmation.customerEmailPayment()+"\n\n\n");
        log.info(format("Consuming the message from payment-topic Topic:: %s", paymentConfirmation));
        repository.save(
                Notification.builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        var customerName = paymentConfirmation.customerFirstnamePayment() + " " + paymentConfirmation.customerLastnamePayment();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.customerEmailPayment(),
                customerName,
                paymentConfirmation.amountPayment(),
                paymentConfirmation.orderReferencePayment()
        );
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotifications(OrderConfirmation orderConfirmation) throws MessagingException {

        System.out.println("\n\n\nSent Tooooooooooooo1111 :"+orderConfirmation.customer().email()+"\n\n\n");
        log.info(format("Consuming the message from order-topic Topic:: %s", orderConfirmation));
        repository.save(
                Notification.builder()
                        .type(ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
        var customerName = orderConfirmation.customer().firstname() + " " + orderConfirmation.customer().lastname();

        System.out.println("\n\n\nSent Tooooooooooooo :"+orderConfirmation.customer().email()+"\n\n\n");
        emailService.sendOrderConfirmationEmail(
                orderConfirmation.customer().email(),
                customerName,
                orderConfirmation.totalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products()
        );
    }
}