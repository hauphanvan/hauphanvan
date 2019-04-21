package com.pack.hauphanvan.exception;

public class ProductNotFoundByCategory extends RuntimeException{
	
	private String category;
	
	public ProductNotFoundByCategory(String category) {
		this.category=category;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	
	
}
