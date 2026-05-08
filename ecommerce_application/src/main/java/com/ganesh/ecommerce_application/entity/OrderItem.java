package com.ganesh.ecommerce_application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Many order items belong to one order
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	// Many order items can have one product
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	private int quantity;

	private double price;

	// Default Constructor
	public OrderItem() {
	}

	// Constructor
	public OrderItem(Order order, Product product, int quantity, double price) {

		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	// Getters & Setters

	public Long getId() {
		return id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
