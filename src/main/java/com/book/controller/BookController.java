package com.book.controller;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.request.BookItem;
import com.book.model.request.BookRequest;
import com.book.model.response.BookResponse;
import com.book.service.BookOrderCalculatorService;
import com.book.utility.BookConstant;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	public BookOrderCalculatorService bookOrderCalculatorService;

	@PostMapping(value = "/bookPrice")
	public ResponseEntity<BookResponse> calculateBookprice(@Valid @RequestBody BookRequest bookRequest)
			throws Exception {
		Double bookPrice = BookConstant.finalPrice;
		try {
			Map<String, Integer> bookMap = bookRequest.getBooks().stream()
					.collect(Collectors.toMap(BookItem::getName, BookItem::getCount, Integer::sum));

			bookPrice = bookOrderCalculatorService.calculateBookPrice(bookMap);
			BookResponse bookResponse = new BookResponse(BookConstant.Response_Message, bookPrice);
			return new ResponseEntity(bookResponse, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}

	}
}