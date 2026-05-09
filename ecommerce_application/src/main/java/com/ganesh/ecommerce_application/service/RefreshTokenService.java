package com.ganesh.ecommerce_application.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.ecommerce_application.entity.RefreshToken;
import com.ganesh.ecommerce_application.repository.RefreshTokenRepository;

@Service
public class RefreshTokenService {

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	// Generate Refresh Token
	public RefreshToken createRefreshToken(String email) {

		RefreshToken refreshToken = new RefreshToken();

		refreshToken.setEmail(email);

		refreshToken.setToken(UUID.randomUUID().toString());

		refreshToken.setExpiryDate(LocalDateTime.now().plusDays(7));

		return refreshTokenRepository.save(refreshToken);
	}
}
