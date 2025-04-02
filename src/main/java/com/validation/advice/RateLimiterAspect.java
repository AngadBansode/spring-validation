package com.validation.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class RateLimiterAspect {

    private final Map<String, Integer> requestCounts = new ConcurrentHashMap<>();
    private final int MAX_REQUESTS = 5;

    @Around("@annotation(com.validation.annonation.RateLimited)")
    public Object rateLimit(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        requestCounts.putIfAbsent(methodName, 0);

        if (requestCounts.get(methodName) >= MAX_REQUESTS) {
            requestCounts.clear();
            throw new RuntimeException("Rate limit exceeded aspect");
        }

        requestCounts.computeIfPresent(methodName, (k, v) -> v + 1);
        Object result = joinPoint.proceed();
        return result;
    }
}

