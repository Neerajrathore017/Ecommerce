package com.ecommerce.Ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Ecommerce.modal.Products;
import com.ecommerce.Ecommerce.service.Product;

@Repository
public interface ProductRepo extends JpaRepository<Products, Integer>{

	Products save(Product products);
	

}
