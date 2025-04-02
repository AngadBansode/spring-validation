package com.validation.service.design;


import org.springframework.stereotype.Service;

@Service("creditCardPayment")
public class CreditCardPaymentService implements PaymentService {
    @Override
    public String processPayment(double amount) {
        return "Processed Credit Card payment of $" + amount;
    }
}
