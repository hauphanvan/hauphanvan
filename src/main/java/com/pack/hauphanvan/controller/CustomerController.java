package com.pack.hauphanvan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.hauphanvan.domain.Customer;
import com.pack.hauphanvan.service.CustomerService;
import com.pack.hauphanvan.service.ProductService;

@RequestMapping("customer")
@Controller
public class CustomerController {
	@Autowired
	private CustomerService cutomerService;
	
	@Autowired
	private AuthenticationManagerBuilder manager;
	
	@RequestMapping("/customers")
	public String showAllCustomer(Model model) {
		model.addAttribute("customers", cutomerService.getAllCustomers());
		
		return "customers";
	}
	
	@RequestMapping(value="/register",method= RequestMethod.GET)
	public String getRegisterForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("newCustomer", customer);
		
		return "register";
	}
	
	@RequestMapping(value="/register",method= RequestMethod.POST)
	public String processRegisterForm(@ModelAttribute("newCustomer") Customer customer) {
		cutomerService.addNewCustomer(customer);
		
		return "redirect:/login";
	}
	
	
}
