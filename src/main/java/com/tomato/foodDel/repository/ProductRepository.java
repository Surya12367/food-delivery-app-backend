package com.tomato.foodDel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomato.foodDel.entity.Product;
import com.tomato.foodDel.entity.User;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	boolean existsByNameAndPrice(String name, Double price);

	List<Product> findByUser(User user);

}
