package com.ecommerce.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce.modal.Users;
import com.ecommerce.Ecommerce.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String greet(HttpServletRequest req) {
		return "Hello from Server "+ req.getSession().getId();
	}
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return userservice.register(user);
	}
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		System.out.println(user);
		return userservice.verify(user);
	}
	
	
	

}
