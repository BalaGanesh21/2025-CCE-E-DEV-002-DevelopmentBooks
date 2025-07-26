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

	
		 double totalPrice=BookConstant.totalPrice;

		while (!checkAllZero(totalBooks)) {
			int uniqueBooks = 0;
			for (int i = 0; i < totalBooks.size(); i++) {

				if (totalBooks.get(i) > 0) {
					uniqueBooks++;
					totalBooks.set(i, totalBooks.get(i) - 1);
				}

			}
			totalPrice += getDiscoutPrice(uniqueBooks);
		}

		return totalPrice;
	}

	public boolean checkAllZero(List<Integer> totalBooks) {
		// TODO Auto-generated method stub
		for (Integer bookcount : totalBooks) {
			if (bookcount != 0) {
				return false;
			}
		}
		return true;
	}

	public double getDiscoutPrice(int uniqueBooks) {

		switch (uniqueBooks) {

		case 2:
			return BookConstant.basePrice * uniqueBooks * 0.95;

		default:
			return BookConstant.basePrice * uniqueBooks;
		}
	}
}
