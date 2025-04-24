package com.validation.controller;

import com.validation.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public String getAsyncResponse() {
      var result=   asyncService.performAsyncTask();
        System.out.println("Result: " + result.join() + "ThreadName: " + Thread.currentThread().getName());
        return "async with completable-future";
    }

    @GetMapping("/process")
    public String processData(@RequestParam String data) {
        asyncService.performAsyncTask(data);
        return "Request accepted for asynchronous processing.";
    }
}
