package com.validation.component;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class OrderTest2 implements com.validation.component.Order {

    @Override
    public String print() {
        System.out.println("OrderTest2.....");
        return  "OrderTest2";
    }

    @PostConstruct
    public void init(){
        System.out.println("OrderTest2....init");
    }

}
