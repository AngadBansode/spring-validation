package com.validation.service.proxy.impl;

import com.validation.service.proxy.Service;

public class Main {

    // Usage
    public static void main(String[] args) {
        Service realService = new RealService();
        Service proxy = new ServiceProxy(realService);
        proxy.performTask();
    }
}
