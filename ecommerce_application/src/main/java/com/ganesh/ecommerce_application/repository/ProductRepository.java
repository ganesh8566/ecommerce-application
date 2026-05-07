package com.ganesh.ecommerce_application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.ecommerce_application.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	// Search products by name
	List<Product> findByNameContaining(String name);

}
