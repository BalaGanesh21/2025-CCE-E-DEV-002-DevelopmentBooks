package com.book.model.response;

public class BookResponse {

	private String message;
	private Double price;

	public BookResponse(String message, Double price) {
		this.message = message;
		this.price = price;
	}

	// Getters and setters

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
