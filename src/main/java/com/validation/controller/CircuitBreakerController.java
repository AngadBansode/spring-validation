package com.validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CircuitBreakerController {

/*    @Autowired
//    private ExternalService externalService;*/

    @GetMapping("/data")
  //  @CircuitBreaker(name = "externalService", fallbackMethod = "fallback")

    public String getData() {
       return "";
    }

    public String fallback(Throwable throwable) {
        return "Fallback response!";
    }
}
