package com.ganesh.ecommerce_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.ecommerce_application.entity.User;
import com.ganesh.ecommerce_application.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Register API
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {

		return userService.registerUser(user);
	}

	// Login API
	@PostMapping("/login")
	public User loginUser(@RequestParam String email, @RequestParam String password) {

		return userService.loginUser(email, password);
	}
}
