package com.ecommerce.Ecommerce.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce.modal.Users;
import com.ecommerce.Ecommerce.repo.UserRepo;
@Service
public class UserService {
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private UserRepo repo;
	
	private  BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	
	 public boolean register(Users user) {
	        // Check if email already exists
	        if (repo.findByEmail(user.getEmail()).isPresent()) {
	            return false; // email already registered
	        }

	        user.setPassword(encoder.encode(user.getPassword()));
	        repo.save(user);
	        return true;
	    }

//	public ResponseEntity<Map<String, Object>> verify(Users user) {
//	    try {
//	        Authentication authentication = authManager.authenticate(
//	                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
//	        );
//
//	        if (authentication.isAuthenticated()) {
//	            String token = jwtservice.generateToken(user.getUsername());
//
//	            Map<String, Object> responseData = new HashMap<>();
//	            responseData.put("token", token);
//
//	            Map<String, Object> response = new HashMap<>();
//	            response.put("responseData", responseData);
//
//	            return ResponseEntity.ok(response);
//	        } else {
//	            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        return ResponseEntity.status(500).body(Map.of("error", "Authentication failed"));
//	    }
//	}
	 public ResponseEntity<Map<String, Object>> verify(Users user) {
	        try {
	            Authentication authentication = authManager.authenticate(
	                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
	            );

	            if (authentication.isAuthenticated()) {
	                String token = jwtService.generateToken(user.getEmail());

	                Map<String, Object> responseData = new HashMap<>();
	                responseData.put("token", token);
	                responseData.put("email", user.getEmail());

	                return ResponseEntity.ok(Map.of("responseData", responseData));
	            } else {
	                return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body(Map.of("error", "Authentication failed"));
	        }
	    }


}
