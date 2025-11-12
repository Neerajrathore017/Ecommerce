package com.ecommerce.Ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce.modal.Products;
import com.ecommerce.Ecommerce.service.Product;

import jakarta.servlet.http.HttpServletRequest;

@RestController
//@CrossOrigin
public class ProductsController {
	
	@Autowired
	private Product product;
//	
//	private List<Products> prod=new ArrayList<Products>(List.of(
//			new Products(1,"laptop",100,"Test1"),
//			new Products(2,"mobile",200,"Test2")
//			));
	@GetMapping("/products")
	 public ResponseEntity<List<Products>> getProducts() {
		System.out.println("Testttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
        List<Products> products = product.getProducts();

        // ✅ Returns JSON response with HTTP 200 OK
        return ResponseEntity.ok(products);
    }
	
    @PostMapping("/addproducts")
    public ResponseEntity<Products> addProduct(@RequestBody Products prod) {
        Products savedProduct = product.addProduct(prod);
        return ResponseEntity.ok(savedProduct);
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
