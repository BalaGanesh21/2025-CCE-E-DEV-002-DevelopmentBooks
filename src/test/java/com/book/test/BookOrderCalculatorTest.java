package com.book.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.BookApplication;
import com.book.service.BookOrderCalculator;




@SpringBootTest(classes=BookApplication.class)
public class BookOrderCalculatorTest {

	@Autowired
	private BookOrderCalculator bookOrderCalculator;

	@Test
	public void checkInvalidMap() {
		Map<String, Integer> book = Map.of();

		assertThrows(Exception.class, () -> {
			bookOrderCalculator.calculateBookPrice(book);
		});
	}

	
	@Test
	public void testSingleSet() throws Exception {

		Map<String, Integer> book = Map.of("Clean Code", 5);
		assertEquals(250, bookOrderCalculator.calculateBookPrice(book), 0.1);
	}

}