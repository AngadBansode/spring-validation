package com.validation.service.impl;

import com.validation.dto.PaymentRequest;
import com.validation.service.payment.PaymentService;
import org.springframework.stereotype.Service;

@Service("Paytm")
public class Paytm implements PaymentService {

    @Override
    public String pay(PaymentRequest request) {
        return request.getAmount() + " paid successfully using " + request.getPaymentMethod();
    }

}