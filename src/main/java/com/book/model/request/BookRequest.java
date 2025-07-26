package com.book.model.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;


public class BookRequest {

	@NotEmpty(message = "Books list cannot be empty")
	@Valid
    private List<BookItem> books;

	
    public List<BookItem> getBooks() {
        return books;
    }

    public void setBooks(List<BookItem> books) {
        this.books = books;
    }
}
