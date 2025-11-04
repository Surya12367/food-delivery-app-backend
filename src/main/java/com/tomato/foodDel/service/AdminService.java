package com.tomato.foodDel.service;

import java.security.Principal;

import com.tomato.foodDel.dto.ProductDto;
import com.tomato.foodDel.dto.ResponseDto;
import com.tomato.foodDel.entity.Category;

public interface AdminService {
	
	ResponseDto addCategory(Category category);

	ResponseDto viewCategories();

	ResponseDto deleteCategory(Long id);

	ResponseDto updateCategory(Long id, Category category);
	
	ResponseDto saveProduct(ProductDto dto, Principal principal);

	ResponseDto getProducts(Principal principal);

	ResponseDto deleteProduct(Long id, Principal principal);

}
