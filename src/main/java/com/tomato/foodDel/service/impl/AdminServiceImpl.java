package com.tomato.foodDel.service.impl;

import java.security.Principal;
import java.util.List;

import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.stereotype.Service;

import com.tomato.foodDel.dao.AdminDao;
import com.tomato.foodDel.dao.UserDao;
import com.tomato.foodDel.dto.ProductDto;
import com.tomato.foodDel.dto.ResponseDto;
import com.tomato.foodDel.entity.Category;
import com.tomato.foodDel.entity.Product;
import com.tomato.foodDel.entity.User;
import com.tomato.foodDel.exception.DataExistsException;
import com.tomato.foodDel.exception.DataNotFoundException;
import com.tomato.foodDel.service.AdminService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService{
	
	AdminDao adminDao;
	UserDao userDao;

	@Override
	public ResponseDto addCategory(Category category) {
		if (adminDao.isCategoryUnique(category.getName())) {
			adminDao.save(category);
			return new ResponseDto("Category Added Success", category);
		} else
			throw new DataExistsException(category.getName() + " Already Present");
	}

	@Override
	public ResponseDto viewCategories() {
		return new ResponseDto("Found Success", adminDao.findAllCategory());
	}

	@Override
	public ResponseDto deleteCategory(Long id) {
		adminDao.deleteCategory(id);
		return new ResponseDto("Deleted Success", null);
	}

	@Override
	public ResponseDto updateCategory(Long id, Category req) {
		Category category = adminDao.findCategoryById(id);
		category.setName(req.getName());
		adminDao.save(category);

		return new ResponseDto("Category Updated Success", category);
	}
	
	@Override
	public ResponseDto saveProduct(ProductDto dto, Principal principal) {
		if (adminDao.isCategoryPresent(dto.getCategory())) {
			if (adminDao.isProductUnique(dto.getName(), dto.getPrice())) {
				Product product = new Product(null, dto.getName(), dto.getDescription(), dto.getPrice(), dto.getStock(),
						dto.getImageLink(), adminDao.getCategory(dto.getCategory()), false,
						userDao.findByEmail(principal.getName()));
				adminDao.saveProduct(product);
				return new ResponseDto("Product Added Success", product);
			} else {
				throw new DataExistsException("Product Already Exists");
			}
		} else {
			throw new DataNotFoundException("No Category with name: " + dto.getCategory());
		}
	}

	@Override
	public ResponseDto getProducts(Principal principal) {
		User user = userDao.findByEmail(principal.getName());
		List<Product> products = adminDao.fetchProducts(user);
		return new ResponseDto("Products Found", products);
	}

	@Override
	public ResponseDto deleteProduct(Long id, Principal principal) {
		Product product = adminDao.findProductById(id);
		if (product.getUser().getEmail().equals(principal.getName()))
			adminDao.deleteProduct(id);
		else
			throw new AuthorizationDeniedException("You can not deleted this product");
		return new ResponseDto("Product Deleted Success", product);
	}


}
