package com.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.price.BookFinalPrice;
import com.book.price.BookPrice;
import com.book.utility.BookConstant;
import com.book.utility.BookUtilityService;
import com.book.validator.Validator;

@Component
public class BookOrderCalculatorService {

	@Autowired
	private BookFinalPrice bookFinalPrice;

	@Autowired
	private BookUtilityService bookUtil;

	@Autowired
	private GroupOptimizer groupOptimizer;
	
	@Autowired
	private Validator validator;

	public Double calculateBookPrice(Map<String, Integer> bookList) throws Exception {

		if (bookList.isEmpty())
			throw new Exception(BookConstant.Basket_Empty);
		
		bookList=validator.removeBooksNotListedInCatalog(bookList,BookConstant.bookCatalog);
		
		List<Integer> totalBooks = new ArrayList<>();

		for (Entry<String, Integer> value : bookList.entrySet()) {
			if (value.getValue() > 0) {
				totalBooks.add(value.getValue());
			}
		}

		double finalPrice = BookConstant.finalPrice;

		List<List<Integer>> groups = createInitialGroups(totalBooks);
		groupOptimizer.optimizeGroups(groups);

		finalPrice = bookFinalPrice.getBooksTotalPrice(groups, BookConstant.finalPrice);

		return finalPrice;
	}

	public List<List<Integer>> createInitialGroups(List<Integer> bookCount) {
		List<List<Integer>> bookGroups = new ArrayList<List<Integer>>();

		while (!bookUtil.checkAllZero(bookCount)) {
			List<Integer> group = new ArrayList<>(bookCount.size());
			for (int i = 0; i < bookCount.size(); i++) {
				if (bookCount.get(i) > 0) {
					group.add(1);
					bookCount.set(i, bookCount.get(i) - 1);
				}
			}
			bookGroups.add(group);
		}

		return bookGroups;
	}

}
