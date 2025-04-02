package com.validation.controller;

import com.validation.dto.PaymentRequest;
import com.validation.service.payment.PaymentRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-service")
public class PaymentController {

    @Autowired
    PaymentRegistry paymentRegistry;

    @PostMapping("/pay")
    public String paymentProcess(@RequestBody PaymentRequest request) {
        String response = "";
        response = paymentRegistry.getBean(request.getPaymentMethod()).pay(request);
        return response;
    }

}
