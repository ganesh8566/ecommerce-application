package com.ganesh.ecommerce_application.dto;

public class JwtResponseDTO {

	private String accessToken;

	private String refreshToken;

	public JwtResponseDTO(String accessToken, String refreshToken) {

		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}
}
