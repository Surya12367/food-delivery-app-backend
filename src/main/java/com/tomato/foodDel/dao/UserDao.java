package com.tomato.foodDel.dao;

import org.springframework.stereotype.Repository;

import com.tomato.foodDel.entity.User;
import com.tomato.foodDel.exception.DataNotFoundException;
import com.tomato.foodDel.repository.UserRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserDao {
	
	UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public boolean isEmailUnique(String email) {
		return !userRepository.existsByEmail(email);
	}

	public boolean isMobileUnique(Long mobile) {
		return !userRepository.existsByMobile(mobile);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow(()->new DataNotFoundException("Email Doesnot Exist"));
	}

}
