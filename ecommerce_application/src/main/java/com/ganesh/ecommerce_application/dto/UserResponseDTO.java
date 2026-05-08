package com.ganesh.ecommerce_application.dto;

public class UserResponseDTO {

	private Long id;

	private String name;

	private String email;

	// Constructor
	public UserResponseDTO(Long id, String name, String email) {

		this.id = id;
		this.name = name;
		this.email = email;
	}

	// Getters

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
