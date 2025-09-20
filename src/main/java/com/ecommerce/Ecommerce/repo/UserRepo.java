package com.ecommerce.Ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Ecommerce.modal.Users;
@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);

}
