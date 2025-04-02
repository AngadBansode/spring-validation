package com.validation;

import com.validation.component.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringValidationApplicationTests {

	@Autowired
	List<Order> orderList;

	 @Test
	void contextLoads() {
	}

	/*@Test
	public void orderTest(){
		assertEquals(orderList.get(0).print(),"OrderTest");
		assertEquals(orderList.get(1).print(),"OrderTest2");
	}*/
}
