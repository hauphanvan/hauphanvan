package com.pack.hauphanvan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class HomeController {
	@RequestMapping
	public String welcome(Model model, HttpServletRequest request) {
		model.addAttribute("greeting", "Welcome to HauPhanVan");
		model.addAttribute("tagline", "This is my first website, and it is not complete yet. But someday it will. "
				+ "And for temporary this website is based on spring mvc, spring security for login, "
				+ "jdbcTemplate for connect to database, and database use in this website is mysql clearDB and free DB host, "
				+ "jsp for view part, a little bootstrap for decoration, and it running on heroku free host server. "
				+ "It look very simple, and nothing much yet, i know. But someday it will become a very very amazing website. "
				+ "And if you are reading this right now, you know where did the most amazing website look like at the beginning :))");
		System.out.println("hello");
		System.out.println((String)request.getServletContext().getRealPath("/"));
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
	
	@RequestMapping("/about")
	public String showAbout() {
		return "about";
	}
}
