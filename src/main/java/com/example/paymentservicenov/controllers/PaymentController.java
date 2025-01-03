package com.example.paymentservicenov.controllers;

import com.example.paymentservicenov.dtos.InitiatePaymentDto;
import com.example.paymentservicenov.services.PaymentService;
import com.example.paymentservicenov.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService _paymentService;
    private final ProductService _productService;

    public PaymentController(PaymentService paymentService,
                             ProductService productService) {
        _paymentService = paymentService;
        _productService = productService;
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

    @GetMapping("/product/{productId}")
    public String getProductDetails(@PathVariable String productId){
        return _productService.getProductDetails(productId);
    }
}
