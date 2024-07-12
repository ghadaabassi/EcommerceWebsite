package com.micro.payementservice.services;

import com.micro.payementservice.controllers.Payment.PaymentRequest;

public interface IPaymentService {
    Integer createPayment(PaymentRequest request);
}
