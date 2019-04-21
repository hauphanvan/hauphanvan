package com.pack.hauphanvan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class HomeController {
	@RequestMapping
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to HauPhanVan.com");
		model.addAttribute("tagline", "The one and only awsome website in the world");
		System.out.println("hello");
		
		return "welcome";
	}
	@RequestMapping("/specialDeal")
	public String specialDeal() {
		
		return "ddhf";
	}
	
	@RequestMapping("/invalidCode")
	public String invalideCode(Model model) {
		model.addAttribute("message", "Invalid Promo Code");
		
		return "exceptionPage";
	}
}
