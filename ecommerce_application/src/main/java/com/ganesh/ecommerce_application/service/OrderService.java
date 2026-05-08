package com.ganesh.ecommerce_application.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ganesh.ecommerce_application.entity.Cart;
import com.ganesh.ecommerce_application.entity.Order;
import com.ganesh.ecommerce_application.entity.OrderItem;
import com.ganesh.ecommerce_application.entity.User;
import com.ganesh.ecommerce_application.repository.CartRepository;
import com.ganesh.ecommerce_application.repository.OrderItemRepository;
import com.ganesh.ecommerce_application.repository.OrderRepository;
import com.ganesh.ecommerce_application.repository.UserRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	// Place Order
	@Transactional
	public Order placeOrder(Long userId) {

		User user = userRepository.findById(userId).orElse(null);

		List<Cart> cartItems = cartRepository.findByUserId(userId);

		double totalAmount = 0;

		// Calculate Total
		for (Cart cart : cartItems) {

			totalAmount += cart.getProduct().getPrice() * cart.getQuantity();
		}

		// Create Order
		Order order = new Order(user, totalAmount, "PLACED", LocalDateTime.now());

		Order savedOrder = orderRepository.save(order);

		// Save Order Items
		for (Cart cart : cartItems) {

			OrderItem orderItem = new OrderItem(savedOrder, cart.getProduct(), cart.getQuantity(),
					cart.getProduct().getPrice());

			orderItemRepository.save(orderItem);
		}

		// Clear Cart
		cartRepository.deleteByUserId(userId);

		return savedOrder;
	}

	// Get User Orders
	public List<Order> getUserOrders(Long userId) {

		return orderRepository.findByUserId(userId);
	}
}
