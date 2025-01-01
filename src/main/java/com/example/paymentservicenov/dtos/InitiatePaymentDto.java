package com.example.paymentservicenov.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentDto {
    private String email;
    private String phoneNumber;
    private String orderId;
    private Long amount;
}
