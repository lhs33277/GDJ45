package com.goodee.ex04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodee.ex04.domain.Product;

@Controller
public class Controller3 {
	
	@PostMapping("/remove1")
	public String remove1(HttpServletRequest request, Model modell) {
		String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Product product = new Product(model, price);
		
		modell.addAttribute("product", product);
		
		return "remove";
		
	}
	
	@PostMapping("/remove2")
	public String remove2(@RequestParam(value="model") String model, @RequestParam(value="price")int price, Model modell) {
		modell.addAttribute("product", new Product(model, price));
		
		return "remove";
	}
	
	

}
