package com.ecommerce.Ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce.modal.Products;
import com.ecommerce.Ecommerce.repo.ProductRepo;

@Service
public class Product {
	@Autowired
	private ProductRepo prod;
	
	public Products addProduct(Products prods) {
		return prod.save(prods);
	}
	public List<Products> getProducts() {
		return prod.findAll();
	}

}
