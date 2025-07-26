package com.book.controllerTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.book.controller.BookController;

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
		Map<String, Integer> book = Map.of("Clean Code", 2, "Clean Coder", 1, "Test Driven Development", 1);
		when(bookOrder.calculateBookPrice(book)).thenReturn(185.0);
		mockMvc.perform(post("/books/bookPrice").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(book))).andExpect(status().isOk());

		verify(bookOrder).calculateBookPrice(book);

	}
}
