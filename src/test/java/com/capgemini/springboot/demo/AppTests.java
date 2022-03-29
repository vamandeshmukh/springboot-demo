package com.capgemini.springboot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTests {

	@Test
	void testTest() {

		assertEquals(5 + 5, 10);
	}

}
