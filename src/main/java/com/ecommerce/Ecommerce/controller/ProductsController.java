package com.ecommerce.Ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce.modal.Products;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ProductsController {
	
	private List<Products> prod=new ArrayList<Products>(List.of(
			new Products(1,"laptop",100),
			new Products(2,"mobile",200)
			));
	@GetMapping("/products")
	public List<Products> getProducts(){
		System.out.println("Test"+ prod);
		return prod;
	}
	
	@PostMapping("/products")
	public List<Products> addProducts(@RequestBody Products prods){
		prod.add(prods);
		return prod;
	}
	
//	@GetMapping("/products")
//	public ResponseEntity<List<Users>> getUsers() {
//        List<Users> users = repo.findAll();
//        System.out.println("why user ar not"+users);// fetch from DB
//        return ResponseEntity.ok(users);
//    }
	
	@GetMapping("/token")
	public CsrfToken getToken(HttpServletRequest request){
		return (CsrfToken) request.getAttribute("_csrf");
	}

}
