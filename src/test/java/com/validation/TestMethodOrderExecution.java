package com.validation;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(1) // this is for all classes in which order they run the Junits
public class TestMethodOrderExecution {

    @Order(2)
    @Test
    public void testA() {
        System.out.println("testA");
    }

    @Order(3)
    @Test
    public void testB() {
        System.out.println("testB");
    }
   @Order(1)
    @Test
    public void testC() {
        System.out.println("testC");
    }
}
