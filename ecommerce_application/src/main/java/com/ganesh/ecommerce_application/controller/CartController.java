package com.ganesh.ecommerce_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.ecommerce_application.entity.Cart;
import com.ganesh.ecommerce_application.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	// Add To Cart API
	@PostMapping
	public Cart addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {

		return cartService.addToCart(userId, productId, quantity);
	}

	// View Cart API
	@GetMapping("/{userId}")
	public List<Cart> getUserCart(@PathVariable Long userId) {

		return cartService.getUserCart(userId);
	}
}
