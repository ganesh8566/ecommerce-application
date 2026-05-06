package com.ganesh.ecommerce_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.ecommerce_application.entity.User;
import com.ganesh.ecommerce_application.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// Register User
	public User registerUser(User user) {

		return userRepository.save(user);
	}

	// Login User
	public User loginUser(String email, String password) {

		User user = userRepository.findByEmail(email);

		if (user != null && user.getPassword().equals(password)) {
			return user;
		}

		return null;
	}
}
