package com.micro.payementservice.services.payment;

import com.micro.payementservice.controllers.Payment.PaymentRequest;

public interface IPaymentService {
    Integer createPayment(PaymentRequest request);
}
