package com.tomato.foodDel.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tomato.foodDel.entity.User;
import com.tomato.foodDel.exception.DataNotFoundException;
import com.tomato.foodDel.repository.UserRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new DataNotFoundException("Invalid Email"));
		return new CustomUser(user);
	}

}
