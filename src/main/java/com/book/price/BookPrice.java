package com.book.price;

import org.springframework.stereotype.Component;

import com.book.utility.BookConstant;


@Component
public class BookPrice {
	
	public double getPriceForEachUniqueSets(int uniqueBooks) {

		switch (uniqueBooks) {

		case 2:
			return BookConstant.basePrice * uniqueBooks * BookConstant.discount_TwoDifferentBooks;
		case 3:
			return BookConstant.basePrice * uniqueBooks * BookConstant.discount_ThreeDifferentBooks;
		case 4:
			return BookConstant.basePrice * uniqueBooks * BookConstant.discount_FourDifferentBooks;
		case 5:
			return BookConstant.basePrice * uniqueBooks * BookConstant.discount_FiveDifferentBooks;
		default:
			return BookConstant.basePrice * uniqueBooks;
		}
	}

}
