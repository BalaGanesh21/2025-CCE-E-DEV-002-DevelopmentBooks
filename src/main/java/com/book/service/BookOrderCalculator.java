package com.book.service;

import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class BookOrderCalculator {

	public double basePrice = 50.0;

	public Double calculateBookPrice(Map<String, Integer> book) throws Exception {

			if(book.isEmpty())
				throw new Exception("Book Basket is empty");
			
			return 0.0;
		}
}
