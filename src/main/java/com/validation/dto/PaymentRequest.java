package com.validation.dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private long amount;
    private String paymentMethod;

}
