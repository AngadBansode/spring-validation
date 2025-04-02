package com.validation.service.payment;

public interface PaymentRegistry {

      PaymentService getBean(String serviceName);

}