package com.pack.hauphanvan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.hauphanvan.domain.Product;
import com.pack.hauphanvan.exception.ProductNotFoundByCategory;
import com.pack.hauphanvan.exception.ProductNotFoundUnderId;
import com.pack.hauphanvan.service.ProductService;

@Controller()
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String showAllProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		
		return "products";
	}
	
	@RequestMapping("/products/{category}")
	public String showProductsByCategory(Model model, @PathVariable("category") String category) {
		List<Product> products = productService.getProductsByCategory(category);
		if(products == null || products.isEmpty()) {
			throw new ProductNotFoundByCategory(category);
		}
		model.addAttribute("products", products);
		
		return "products";
	}
	
	@RequestMapping("/product")
	public String showProductById(Model model, @RequestParam("id") String productId) {
		try {
			model.addAttribute("product", productService.getProductById(productId));
		}catch(Exception e) {
			throw new ProductNotFoundUnderId(productId);
		}
		
		return "product";
	}
	
	@RequestMapping("/products/filter/{params}")
	public String showProductByFilter(Model model, @MatrixVariable(pathVar = "params") Map<String, List<String>> filterParam) {
		model.addAttribute("products", productService.getProductsByFilter(filterParam));
		
		return "products";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("newProduct", product);
		
		return "addNewProduct";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product product, BindingResult result) {
		String suppressedFields[] = result.getSuppressedFields();
		if(suppressedFields.length > 0) {
			throw new RuntimeException("Attemting to bind disallowed fields: " + suppressedFields.toString());
		}
		
		productService.addNewProduct(product);
		
		return "redirect:/product/products";
	}
	
	@InitBinder
	public void initialize(WebDataBinder binder) {
		binder.setAllowedFields("productId", "name", "unitPrice", "manufacturer", "category", "unitsInStock", "unitsInOrder", "condition", "description", "discontinued", "language");
	}
	
	@ExceptionHandler(ProductNotFoundByCategory.class)
	public String handleException(Model model, ProductNotFoundByCategory exception) {
		model.addAttribute("message", "Can not Found Products Under Category: " + exception.getCategory());
		return "exceptionPage";
	}
	
	@ExceptionHandler(ProductNotFoundUnderId.class)
	public String handlerProductNotFoundId(Model model, ProductNotFoundUnderId exception) {
		model.addAttribute("message", "Can not found product under Id: "+exception.getProductId());
		
		return "exceptionPage";
	}
}
