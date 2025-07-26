package com.book.price;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookFinalPrice {

	@Autowired
	private BookPrice bookPrice;

	public double getBooksTotalPrice(List<List<Integer>> groups, double totalPrice) {

		for (List<Integer> group : groups) {
			int bookSet = (int) group.stream().filter(uniqueBooks -> uniqueBooks > 0).count();
			totalPrice += bookPrice.getPriceForEachUniqueSets(bookSet);
		}

		return totalPrice;

	}

}
