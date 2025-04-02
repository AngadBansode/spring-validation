package com.validation.service.proxy.impl;

import com.validation.service.proxy.Service;

public class RealService implements Service {
    @Override
    public void performTask() {
        System.out.println("Executing Real Service Task");
    }
}