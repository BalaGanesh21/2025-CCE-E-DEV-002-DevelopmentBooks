package com.book.price;

import org.springframework.stereotype.Component;

import com.book.utility.BookConstant;


@Component
public class BookPrice {
	
	public double getBookPrice(int uniqueBooks) {

		switch (uniqueBooks) {

		case 2:
			return BookConstant.basePrice * uniqueBooks * 0.95;
		case 3:
			return BookConstant.basePrice * uniqueBooks * 0.90;
		case 4:
			return BookConstant.basePrice * uniqueBooks * 0.80;
		case 5:
			return BookConstant.basePrice * uniqueBooks * 0.75;
		default:
			return BookConstant.basePrice * uniqueBooks;
		}
	}

}
