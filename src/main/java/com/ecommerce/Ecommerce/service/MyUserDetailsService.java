package com.ecommerce.Ecommerce.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce.modal.UserPrincipal;
import com.ecommerce.Ecommerce.modal.Users;
import com.ecommerce.Ecommerce.repo.UserRepo;
@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user=repo.findByUsername(username);
		if (user==null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("User nhi mil rha");
		}
		return new UserPrincipal(user);
	}

}
