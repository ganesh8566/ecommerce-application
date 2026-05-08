package com.ganesh.ecommerce_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.ecommerce_application.dto.LoginResponseDTO;
import com.ganesh.ecommerce_application.dto.UserResponseDTO;
import com.ganesh.ecommerce_application.entity.User;
import com.ganesh.ecommerce_application.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Register API
	@PostMapping("/register")
	public UserResponseDTO registerUser(@Valid @RequestBody User user) {

		User savedUser = userService.registerUser(user);

		return new UserResponseDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
	}

	// Login API
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {

		User user = userService.loginUser(email, password);

		// Wrong Credentials
		if (user == null) {

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
		}

		// Convert Entity → DTO
		UserResponseDTO userDTO = new UserResponseDTO(user.getId(), user.getName(), user.getEmail());

		LoginResponseDTO response = new LoginResponseDTO("Login Successful", userDTO);

		return ResponseEntity.ok(response);
	}
}
