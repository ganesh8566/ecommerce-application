package com.ganesh.ecommerce_application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Many cart items can belong to one user
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// Many cart items can belong to one product
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	private int quantity;

	// Default Constructor
	public Cart() {
	}

	// Constructor
	public Cart(User user, Product product, int quantity) {
		this.user = user;
		this.product = product;
		this.quantity = quantity;
	}

	// Getters & Setters

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
