/*
package com.validation.controller;

import com.validation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/reactive-users")
public class UserReactiveController {

    @Autowired
    private UserReactiveRepository repository;

    @GetMapping
    public Flux<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/age/{age}")
    public Flux<User> getUsersByAge(@PathVariable int age) {
        return repository.findByAgeGreaterThan(age);
    }
}
*/
