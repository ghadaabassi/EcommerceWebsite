package com.micro.notificationservice.services;

import com.micro.notificationservice.entities.Product;
import jakarta.mail.MessagingException;

import java.math.BigDecimal;
import java.util.List;

public interface IEmailService {
    void sendPaymentSuccessEmail(String s, String customerName, BigDecimal amount, String s1)throws MessagingException;;

    void sendOrderConfirmationEmail(String email, String customerName, BigDecimal bigDecimal, String s, List<Product> products)throws MessagingException;;
}
