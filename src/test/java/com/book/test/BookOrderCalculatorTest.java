package com.book.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.BookApplication;
import com.book.service.BookOrderCalculatorService;




@SpringBootTest(classes=BookApplication.class)
public class BookOrderCalculatorTest {

	@Autowired
	private BookOrderCalculatorService bookOrderCalculator;

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

	@Test
	public void checkPriceForTwoDifferentBooks() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",2,"Clean Coder",2);
		assertEquals(190, bookOrderCalculator.calculateBookPrice(book),0.1);
		
	}

	@Test 
	public void checkPriceForThreeDifferentBooks() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",2,"Clean Coder",1,
				"Test Driven Development",1);
		assertEquals(185.0,bookOrderCalculator.calculateBookPrice(book),0.1);
	}
	
	@Test 
	public void checkPriceForFourDifferentBooks() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",2,"Clean Coder",1,"Clean Architecture",2,
				"Test Driven Development",1);
		assertEquals(255.0,bookOrderCalculator.calculateBookPrice(book),0.1);
	}
	
	
	@Test 
	public void checkPriceForFiveDifferentBooks() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",2, "Clean Coder", 1,"Clean Architecture",2,
				"Test Driven Development", 1,"Working effectively with Legacy Code",2);
		assertEquals(320.0,bookOrderCalculator.calculateBookPrice(book),0.1);
	}
	


	
	@Test 
	public void testPriceforComplexSetOne() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",2,"Clean Coder",2,"Clean Architecture",2,
				"Test Driven Development",1,"Working effectively with Legacy Code",1);
		assertEquals(320.0,bookOrderCalculator.calculateBookPrice(book),0.1);
	}
	

	
	@Test 
	public void testRemoveInvalidBooks() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",2,"Clean Coder",2,"Clean",2,
				"Test Driven Development",1,"Working effectively with Legacy Code",1);
		assertEquals(255.0,bookOrderCalculator.calculateBookPrice(book),0.1);
	}
	
	@Test
	public void testPriceforComplexSetTwo() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",4,"Clean Coder",3,"Clean Architecture",
				4,"Test Driven Development",5,"Working effectively with Legacy Code",4);
		assertEquals(772.5,bookOrderCalculator.calculateBookPrice(book),0.1);
	} 
	
	
	@Test
	public void testPriceforComplexSetThree() throws Exception{
		Map<String,Integer> book=Map.of("Clean Code",1,"Clean Coder",2,"Clean Architecture",
				3,"Test Driven Development",4,"Working effectively with Legacy Code",5);
		assertEquals(585.0,bookOrderCalculator.calculateBookPrice(book),0.1);
	}
}