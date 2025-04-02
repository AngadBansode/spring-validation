package com.validation.service.design;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentServiceRegistry {

    private final Map<String, PaymentService> paymentServiceMap;

    @Autowired
    public PaymentServiceRegistry(Map<String, PaymentService> paymentServiceMap) {
        this.paymentServiceMap = paymentServiceMap;
    }

    public PaymentService getPaymentService(String paymentType) {
        PaymentService paymentService = paymentServiceMap.get(paymentType/*.toLowerCase()*/);
        if (paymentService == null) {
            throw new IllegalArgumentException("Invalid payment type: " + paymentType);
        }
        return paymentService;
    }
}
