package com.book.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookItem {

	@NotBlank(message="Book name should not be blank")
    private String bookName;
	
	@NotNull(message="Book count should not be Zero")
    private int count;

    public BookItem() {}

    public BookItem(String bookName, int count) {
        this.bookName = bookName;
        this.count = count;
    }

    public String getName() {
        return bookName;
    }

    public void setName(String bookName) {
        this.bookName = bookName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
