package com.book.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookUtilityService {

	
	public boolean checkAllZero(List<Integer> booksCount) {
		// TODO Auto-generated method stub
		for (Integer i : booksCount) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

	
	public List<List<Integer>> createInitialGroups(List<Integer> bookCount) {
		List<List<Integer>> bookGroups = new ArrayList<List<Integer>>();

		while (!checkAllZero(bookCount)) {
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
