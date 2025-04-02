package com.validation.component;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class OrderTest implements com.validation.component.Order {


    @Override
    public String print() {
        System.out.println("OrderTest.....1");
        return  "OrderTest";
    }

    @PostConstruct
    public void init(){
        System.out.println("OrderTest....init");
    }
}
