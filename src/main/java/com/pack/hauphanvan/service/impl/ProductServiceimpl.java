package com.pack.hauphanvan.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.hauphanvan.domain.Product;
import com.pack.hauphanvan.repository.ProductRepository;
import com.pack.hauphanvan.service.ProductService;

@Service
public class ProductServiceimpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		
		return productRepository.getAllProducts();
	}

	public List<Product> getProductsByCategory(String category) {
		
		return productRepository.getProductsByCategory(category);
	}

	public List<Product> getProductsByFilter(Map<String, List<String>> filterParam) {
		
		return productRepository.getProductsByFilter(filterParam);
	}

	public Product getProductById(String productId) {
		
		return productRepository.getProductById(productId);
	}

	public void addNewProduct(Product product) {
		productRepository.addNewProduct(product);
	}

}
