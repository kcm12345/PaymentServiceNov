package com.example.paymentservicenov.controllers;

import com.example.paymentservicenov.dtos.InitiatePaymentDto;
import com.example.paymentservicenov.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService _paymentService;

    public PaymentController(PaymentService paymentService) {
        _paymentService = paymentService;
    }

    @PostMapping
    public String initiatePayment(@RequestBody InitiatePaymentDto initiatePaymentDto){
        return _paymentService.initiatePayment(initiatePaymentDto.getOrderId(),
                initiatePaymentDto.getAmount(),
                initiatePaymentDto.getEmail(),
                initiatePaymentDto.getPhoneNumber());
    }

    @PostMapping("/webhook")
    public String listenToWebhook(@RequestBody String eventWebhook){
        System.out.println("test:"+eventWebhook);
        return "ok";
    }
}
