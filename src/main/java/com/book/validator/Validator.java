package com.book.validator;

import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class Validator {

	public Map<String, Integer> removeBooksNotListedInCatalog(Map<String, Integer> book, List<String> bookList) {

		Map<String, Integer> filterBooks = new ConcurrentHashMap<String, Integer>(book);

		for (Entry<String, Integer> books : filterBooks.entrySet()) {

			if (!bookList.contains(books.getKey())) {
				filterBooks.remove(books.getKey());
			}

		}
		return filterBooks;
	}
}
