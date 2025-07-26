package com.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.book.utility.BookConstant;

@Component
public class BookOrderCalculator {


	public Double calculateBookPrice(Map<String, Integer> bookList) throws Exception {

		if (bookList.isEmpty())
			throw new Exception(BookConstant.Basket_Empty);


		List<Integer> totalBooks = new ArrayList<>();

		for (Entry<String, Integer> value : bookList.entrySet()) {
			if (value.getValue() > 0) {
				totalBooks.add(value.getValue());
			}
		}
		
		
		for (Integer i : totalBooks) {
				return BookConstant.basePrice*i;
			}

		return 0.0;

	}
}
