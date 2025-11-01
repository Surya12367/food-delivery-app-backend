package com.tomato.foodDel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomato.foodDel.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	boolean existsByEmail(String email);

	boolean existsByMobile(Long mobile);
	
	Optional<User> findByEmail(String email);
	
	boolean existsByEmailOrMobile(String email, Long mobile);

}
