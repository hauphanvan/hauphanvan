package com.pack.hauphanvan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Can not found product under category!")
public class ProductNotFoundUnderCategory extends RuntimeException{
	private String category;

	public ProductNotFoundUnderCategory(String category) {
		this.category=category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
}
