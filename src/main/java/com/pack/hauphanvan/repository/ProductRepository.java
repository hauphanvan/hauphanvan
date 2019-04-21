package com.pack.hauphanvan.repository;

import java.util.List;
import java.util.Map;

import com.pack.hauphanvan.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	List<Product> getProductsByFilter(Map<String, List<String>> filterParam);
	Product getProductById(String productId);
	void addNewProduct(Product product);
}
