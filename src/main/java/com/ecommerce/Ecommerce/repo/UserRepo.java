package com.ecommerce.Ecommerce.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Ecommerce.modal.Users;
@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);
	Optional<Users> findByEmail(String email);

}
