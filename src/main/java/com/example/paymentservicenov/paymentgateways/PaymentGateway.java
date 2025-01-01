package com.example.paymentservicenov.paymentgateways;

public interface PaymentGateway {
    String generatePaymentLink(String orderId, Long amount, String email, String phoneNumber);
}
