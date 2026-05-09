package com.ganesh.ecommerce_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.ecommerce_application.dto.JwtResponseDTO;
import com.ganesh.ecommerce_application.dto.LoginRequestDTO;
import com.ganesh.ecommerce_application.dto.UserResponseDTO;
import com.ganesh.ecommerce_application.entity.User;
import com.ganesh.ecommerce_application.jwt.JwtUtil;
import com.ganesh.ecommerce_application.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	// Register API
	@PostMapping("/register")
	public UserResponseDTO registerUser(@Valid @RequestBody User user) {

		User savedUser = userService.registerUser(user);

		return new UserResponseDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
	}

	// Login API
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequestDTO loginDTO) {

		User user = userService.loginUser(loginDTO.getEmail(), loginDTO.getPassword());

		// Wrong Credentials
		if (user == null) {

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
		}

		// Generate JWT Token
		String token = jwtUtil.generateToken(user.getEmail(), user.getRole());

		return ResponseEntity.ok(new JwtResponseDTO(token));
	}
}
