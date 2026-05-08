package com.ganesh.ecommerce_application.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Many orders can belong to one user
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private double totalAmount;

	private String status;

	private LocalDateTime orderDate;

	// Default Constructor
	public Order() {
	}

	// Constructor
	public Order(User user, double totalAmount, String status, LocalDateTime orderDate) {

		this.user = user;
		this.totalAmount = totalAmount;
		this.status = status;
		this.orderDate = orderDate;
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

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
}
