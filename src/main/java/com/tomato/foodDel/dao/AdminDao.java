package com.tomato.foodDel.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tomato.foodDel.entity.Category;
import com.tomato.foodDel.entity.Product;
import com.tomato.foodDel.entity.User;
import com.tomato.foodDel.exception.DataNotFoundException;
import com.tomato.foodDel.repository.CategoryRepository;
import com.tomato.foodDel.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class AdminDao {
	
	CategoryRepository categoryRepository;
	ProductRepository productRepository;

	public boolean isCategoryUnique(String name) {
		return !categoryRepository.existsByName(name);
	}

	public void save(Category category) {
		categoryRepository.save(category);
	}

	public List<Category> findAllCategory() {
		List<Category> list = categoryRepository.findAll();
		if (list.isEmpty())
			throw new DataNotFoundException("No Categories Present");
		else
			return list;
	}

	public void deleteCategory(Long id) {
		findCategoryById(id);
		categoryRepository.deleteById(id);
	}

	public Category findCategoryById(Long id) {
		return categoryRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Category Not Found"));
	}
	
	public void saveProduct(Product prodcut) {
		productRepository.save(prodcut);
	}

	public Category getCategory(String category) {
		return categoryRepository.findByName(category);
	}

	public boolean isCategoryPresent(String category) {
		return categoryRepository.existsByName(category);
	}

	public boolean isProductUnique(String name, Double price) {
		return !productRepository.existsByNameAndPrice(name, price);
	}

	public List<Product> fetchProducts(User user) {
		List<Product> products = productRepository.findByUser(user);
		if (products.isEmpty())
			throw new DataNotFoundException("No Products Present");
		else
			return products;
	}

	public Product findProductById(Long id) {
		return productRepository.findById(id).orElseThrow(()->new DataNotFoundException("Product Not Found with Id: "+id));
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
