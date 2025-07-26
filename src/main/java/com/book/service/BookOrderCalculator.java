package com.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

@Component
public class BookOrderCalculator {

	public double basePrice = 50.0;

	public Double calculateBookPrice(Map<String, Integer> bookList) throws Exception {

		if (bookList.isEmpty())
			throw new Exception("Book Basket is empty");


		List<Integer> totalBooks = new ArrayList<>();

		for (Entry<String, Integer> value : bookList.entrySet()) {
			if (value.getValue() > 0) {
				totalBooks.add(value.getValue());
			}
		}
		
		
		for (Integer i : totalBooks) {
				return basePrice*i;
			}

		return 0.0;

	}
}
