package com.micro.payementservice.services;

import com.micro.payementservice.controllers.Payment.PaymentRequest;
import com.micro.payementservice.repositories.IPaymentRepository;
import com.micro.payementservice.services.notification.NotificationProducer;
import com.micro.payementservice.services.notification.PaymentNotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements IPaymentService {
    private final IPaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;

    @Override
    public Integer createPayment(PaymentRequest request) {
        var payment = this.paymentRepository.save(this.paymentMapper.toPayment(request));

        this.notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }
}
