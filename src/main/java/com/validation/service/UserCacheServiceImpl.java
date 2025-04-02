package com.validation.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserCacheServiceImpl {

 /*   @Autowired
    private HazelcastInstance hazelcastInstance;*/


    @Cacheable(value = "users", key = "#id")
    public String getUserById(String id) {
        simulateSlowService(); // Simulate a slow method
        return "User-" + id;
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(5000); // Simulates a 2-second delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
