package com.book.utility;

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

}
