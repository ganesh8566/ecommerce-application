package com.ganesh.ecommerce_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.ecommerce_application.dto.JwtResponseDTO;
import com.ganesh.ecommerce_application.dto.LoginRequestDTO;
import com.ganesh.ecommerce_application.dto.UserResponseDTO;
import com.ganesh.ecommerce_application.entity.RefreshToken;
import com.ganesh.ecommerce_application.entity.User;
import com.ganesh.ecommerce_application.jwt.JwtUtil;
import com.ganesh.ecommerce_application.repository.RefreshTokenRepository;
import com.ganesh.ecommerce_application.service.RefreshTokenService;
import com.ganesh.ecommerce_application.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RefreshTokenService refreshTokenService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

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
		String accessToken = jwtUtil.generateToken(user.getEmail(), user.getRole());

		RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getEmail());

		return ResponseEntity.ok(new JwtResponseDTO(accessToken, refreshToken.getToken()));
	}

	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestParam String refreshToken) {

		RefreshToken token = refreshTokenRepository.findByToken(refreshToken).orElse(null);

		if (token == null) {

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Refresh Token");
		}

		// Generate New Access Token
		String accessToken = jwtUtil.generateToken(token.getEmail(), "ROLE_USER");

		return ResponseEntity.ok(new JwtResponseDTO(accessToken, refreshToken));
	}
}
