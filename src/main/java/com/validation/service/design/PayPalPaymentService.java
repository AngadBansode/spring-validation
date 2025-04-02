package com.validation.service.design;

import org.springframework.stereotype.Service;

@Service("paypalPayment")
public class PayPalPaymentService implements PaymentService {
    @Override
    public String processPayment(double amount) {
        return "Processed PayPal payment of $" + amount;
    }
}
