package com.validation.service.impl;

public class MesseageService {

    public static int counter = 0;

    public MesseageService(){
        System.out.println("ctor cnt increase: " + counter++);
    }

    public int increaseCount() {
        System.out.println("Counter method : " + counter++);
        return counter;
    }
}
