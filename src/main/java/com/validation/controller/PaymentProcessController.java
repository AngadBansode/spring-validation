package com.validation.controller;

import com.validation.service.design.PaymentService;
import com.validation.service.design.PaymentServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentProcessController {


    @Autowired
    private PaymentServiceRegistry paymentServiceRegistry;

    @PostMapping("/process")
    public String processPayment(@RequestParam String paymentType, @RequestParam double amount) {
        PaymentService paymentService = paymentServiceRegistry.getPaymentService(paymentType);
        return paymentService.processPayment(amount);
    }
}
