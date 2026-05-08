package com.ganesh.ecommerce_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.ecommerce_application.entity.Order;
import com.ganesh.ecommerce_application.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	// Place Order API
	@PostMapping("/{userId}")
	public Order placeOrder(@PathVariable Long userId) {

		return orderService.placeOrder(userId);
	}

	// Order History API
	@GetMapping("/{userId}")
	public List<Order> getUserOrders(@PathVariable Long userId) {

		return orderService.getUserOrders(userId);
	}
}
