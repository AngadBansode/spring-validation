package com.validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/secure")
public class ClientSecureController {
    private final RestTemplate restTemplate;

        @Autowired
        public ClientSecureController(RestTemplate restTemplate) {

            this.restTemplate = restTemplate;
        }
        @GetMapping()
        public String callSecureService() {
            String url = "https://localhost:8443/api/get";
            return restTemplate.getForObject(url, String.class);
        }

}
