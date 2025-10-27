package com.ecommerce.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	private JWTService jwtservice;
	
	@Autowired
	private UserRepo repo;
	
	private  BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	
	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
		
	}

	public String verify(Users user) {
		// TODO Auto-generated method stub
		Authentication authentication= authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtservice.generateToken(user.getUsername());
		}
		return "Fail";

	};

}
