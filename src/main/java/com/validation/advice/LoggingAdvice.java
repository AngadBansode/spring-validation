package com.validation.advice;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {

    @Pointcut("execution(* com.validation.service.impl.UserServiceImpl.*(..))")
    private void logPointcut() {
    }

    @Before("logPointcut()")
    public void logRequest(JoinPoint joinPoint) throws JsonProcessingException {
        log.info("Before Advice - class name {} ,method name {} ", joinPoint.getTarget(), joinPoint.getSignature().getName());
        log.info("Before Advice - Request Body {} ", new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
    }

//    @AfterReturning(value = "execution (* com.javatechie.controller.ProductController.*(..))",returning = "object")
//    public void logResponse(JoinPoint joinPoint,Object object) throws JsonProcessingException {
//        log.info("LoggingAdvice::logResponse class name {} ,method name {} ", joinPoint.getTarget(), joinPoint.getSignature().getName());
//        log.info("LoggingAdvice::logResponse Response Body {} ", new ObjectMapper().writeValueAsString(object));
//    }

    @After("logPointcut()") // after method execution, in both cases, failure or success
    public void logResponseAfter(JoinPoint joinPoint) throws JsonProcessingException {
        log.info("After Advice - LoggingAdvice::logResponse class name {} ,method name {} ", joinPoint.getTarget(), joinPoint.getSignature().getName());
        log.info("After Advice - LoggingAdvice::logResponse Response Body {} ", new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
    }


//    @AfterReturning(value = "execution (* com.javatechie.service.ProductService.*(..))")
    @AfterReturning("logPointcut()") // if methods throws exceptions it won't execute, only in success case
    public void logResponse(JoinPoint joinPoint) throws JsonProcessingException {
        log.info("AfterReturning Advice - LoggingAdvice::logResponse class name {} ,method name {} ", joinPoint.getTarget(), joinPoint.getSignature().getName());
        log.info("AfterReturning Advice - LoggingAdvice::logResponse Response Body {} ", new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
    }


//    @AfterThrowing(value = "execution (* com.javatechie.service.ProductService.*(..))")
    @AfterThrowing("logPointcut()")
    public void logError(JoinPoint joinPoint) throws JsonProcessingException {
        log.info("Throws Advice - LoggingAdvice::logResponse class name {} ,method name {} ", joinPoint.getTarget(), joinPoint.getSignature().getName());
        log.info("Throws Advice - LoggingAdvice::logResponse Response Body {} ", new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
    }


}