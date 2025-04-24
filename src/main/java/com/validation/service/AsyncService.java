package com.validation.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {
    @Async("AsyncTaskExecutor")
    public CompletableFuture<String> performAsyncTask() {
        System.out.println("Async completable future task started...ThreadName: " + Thread.currentThread().getName());
        try {
            Thread.sleep(8000); // Simulate a long-running operation
            System.out.println("In-Async service: ThreadName - " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed - Async completable future task...!!!");
        return CompletableFuture.completedFuture("Task Completed!");
    }

    @Async("AsyncTaskExecutor")
    public void performAsyncTask(String data) {
        // Simulate a long-running task
        System.out.println("Async task started...!!!");
        try {
            Thread.sleep(5000);// 5 sec wait main thread
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Async task completed with data: " + data + " in thread: " + Thread.currentThread().getName());
    }

}
