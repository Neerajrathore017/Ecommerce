package com.ecommerce.Ecommerce.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce.modal.Users;
import com.ecommerce.Ecommerce.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin
public class LoginController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String greet(HttpServletRequest req) {
		return "Hello from Server "+ req.getSession().getId();
	}
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Users user) {
	    try {
	        boolean isRegistered = userservice.register(user);

	        if (isRegistered) {
	            return ResponseEntity.ok(Map.of("message", "Registration successful"));
	        } else {
	            return ResponseEntity.badRequest().body(Map.of("message", "Email already exists"));
	        }
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().body(Map.of("message", "Registration failed"));
	    }
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Users user) {
		System.out.println("llllllllllllllllllllllllllll"+ user);
	    return userservice.verify(user);
	}

	
	
	

}
