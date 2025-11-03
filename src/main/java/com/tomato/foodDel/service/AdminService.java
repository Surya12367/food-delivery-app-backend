package com.tomato.foodDel.service;

import com.tomato.foodDel.dto.ResponseDto;
import com.tomato.foodDel.entity.Category;

public interface AdminService {
	
	ResponseDto addCategory(Category category);

	ResponseDto viewCategories();

	ResponseDto deleteCategory(Long id);

	ResponseDto updateCategory(Long id, Category category);

}
