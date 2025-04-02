package com.validation.controller;

import com.validation.annonation.RateLimited;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rateaspect")
public class RateLimiterAspectController {

    @RateLimited
    @GetMapping("/api/demo")
    public String demo() {
        return "Rate-limited endpoint!";
    }
}
