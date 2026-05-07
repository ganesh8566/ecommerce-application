package com.ganesh.ecommerce_application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.ecommerce_application.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	List<Cart> findByUserId(Long userId);

}
