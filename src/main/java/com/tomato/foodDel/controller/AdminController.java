package com.tomato.foodDel.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tomato.foodDel.dto.ProductDto;
import com.tomato.foodDel.dto.ResponseDto;
import com.tomato.foodDel.entity.Category;
import com.tomato.foodDel.service.AdminService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	AdminService adminService;

	@PostMapping("/category")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseDto addCategory(@RequestBody Category category) {
		return adminService.addCategory(category);
	}

	@GetMapping("/category")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseDto viewCategories() {
		return adminService.viewCategories();
	}

	@DeleteMapping("/category/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseDto deleteCategory(@PathVariable Long id) {
		return adminService.deleteCategory(id);
	}

	@PutMapping("/category/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseDto updateCategory(@PathVariable Long id, @RequestBody Category category) {
		return adminService.updateCategory(id, category);
	}
	
	@PostMapping("/products")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseDto saveProduct(@Valid @RequestBody ProductDto productDto, Principal principal) {
		return adminService.saveProduct(productDto, principal);
	}

	@GetMapping("/products")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseDto getProducts(Principal principal) {
		return adminService.getProducts(principal);
	}

	@DeleteMapping("/products/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseDto deleteProduct(@PathVariable Long id,Principal principal) {
		return adminService.deleteProduct(id,principal);
	}

}
