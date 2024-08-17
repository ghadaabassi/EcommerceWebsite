package com.micro.payementservice.controllers.Payment;

import com.micro.payementservice.services.payment.IPaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

    private final IPaymentService paymentService;

    @PostMapping
    public ResponseEntity<Integer> createPayment(
            @RequestBody @Valid PaymentRequest request
    ) {
        return ResponseEntity.ok(this.paymentService.createPayment(request));
    }
}
