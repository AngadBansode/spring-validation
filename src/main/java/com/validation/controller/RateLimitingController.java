package com.validation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("")
public class RateLimitingController {

    @GetMapping("/api/test")
    public String testRateLimiting() {
        return "Request Successful!";
    }

}
