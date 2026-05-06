package com.ganesh.ecommerce_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.ecommerce_application.entity.Product;
import com.ganesh.ecommerce_application.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	// Add Product API
	@PostMapping
	public Product addProduct(@RequestBody Product product) {

		return productService.addProduct(product);
	}

	// Get All Products API
	@GetMapping
	public List<Product> getAllProducts() {

		return productService.getAllProducts();
	}
}
