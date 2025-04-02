package com.validation.service.design;

import org.springframework.stereotype.Service;

@Service("bankTransferPayment")
public class BankTransferPaymentService implements PaymentService {
    @Override
    public String processPayment(double amount) {
        return "Processed Bank Transfer payment of $" + amount;
    }
}
