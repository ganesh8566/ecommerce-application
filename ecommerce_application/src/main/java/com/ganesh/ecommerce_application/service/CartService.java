package com.ganesh.ecommerce_application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.ecommerce_application.entity.Cart;
import com.ganesh.ecommerce_application.entity.Product;
import com.ganesh.ecommerce_application.entity.User;
import com.ganesh.ecommerce_application.repository.CartRepository;
import com.ganesh.ecommerce_application.repository.ProductRepository;
import com.ganesh.ecommerce_application.repository.UserRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	// Add To Cart
	public Cart addToCart(Long userId, Long productId, int quantity) {

		User user = userRepository.findById(userId).orElse(null);

		Product product = productRepository.findById(productId).orElse(null);

		Cart cart = new Cart(user, product, quantity);

		return cartRepository.save(cart);
	}

	// View Cart
	public List<Cart> getUserCart(Long userId) {

		return cartRepository.findByUserId(userId);
	}
}
