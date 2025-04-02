package com.validation.controller;

import com.validation.service.UserCacheServiceImpl;
import com.validation.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCacheController {


    @Autowired
    private UserCacheServiceImpl userService;

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable String id) {
        return userService.getUserById(id);
    }
}
