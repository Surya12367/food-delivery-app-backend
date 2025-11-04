package com.tomato.foodDel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomato.foodDel.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	boolean existsByName(String name);
	
	Category findByName(String category);

}
