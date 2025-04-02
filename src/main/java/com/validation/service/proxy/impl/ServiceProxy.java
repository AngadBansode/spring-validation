package com.validation.service.proxy.impl;

import com.validation.service.proxy.Service;

// Proxy
public class ServiceProxy implements Service {
    private final Service realService;

    public ServiceProxy(Service realService) {
        this.realService = realService;
    }

    @Override
    public void performTask() {
        System.out.println("Logging: Before executing task");
        realService.performTask();
        System.out.println("Logging: After executing task");
    }
}