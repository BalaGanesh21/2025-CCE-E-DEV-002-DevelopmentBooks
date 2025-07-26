package com.book.controllerTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.book.controller.BookController;
import com.book.model.request.BookItem;
import com.book.model.request.BookRequest;
import com.book.service.BookOrderCalculatorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BookController.class)
public class BookControllerTest {

	@MockBean
	private BookOrderCalculatorService bookOrder;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testOrderBookAPI() throws JsonProcessingException, Exception {

		BookItem itemOne = new BookItem();
		itemOne.setName("Clean Code");
		itemOne.setCount(2);

		BookItem itemTwo = new BookItem();
		itemTwo.setName("Clean Coder");
		itemTwo.setCount(2);

		List<BookItem> listOfItems = new ArrayList<>();
		listOfItems.add(itemOne);
		listOfItems.add(itemTwo);

		BookRequest request = new BookRequest();
		request.setBooks(listOfItems);

		Map<String, Integer> bookList = new HashMap<>();
		bookList.put("Clean Code", 2);
		bookList.put("Clean Coder", 2);
		when(bookOrder.calculateBookPrice(bookList)).thenReturn(190.0);
		mockMvc.perform(post("/books/bookPrice").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk());

		verify(bookOrder).calculateBookPrice(bookList);

	}

	@Test
	public void testOrderBookException() throws JsonProcessingException, Exception {
		List<BookItem> item = new ArrayList<>();
		BookRequest request = new BookRequest();
		request.setBooks(item);

		mockMvc.perform(post("/books/bookPrice").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isBadRequest());

	}
}
