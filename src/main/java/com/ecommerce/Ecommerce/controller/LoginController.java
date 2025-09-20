package com.ecommerce.Ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
	
	@GetMapping("/")
	public String greet(HttpServletRequest req) {
		return "Hello from Server "+ req.getSession().getId();
	}
	
	

}
