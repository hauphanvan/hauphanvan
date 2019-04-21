package com.pack.hauphanvan.exception;

public class ProductNotFoundUnderId extends RuntimeException{
	private String productId;
	
	public ProductNotFoundUnderId(String productId) {
		this.productId=productId;
	}
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	
	
}
