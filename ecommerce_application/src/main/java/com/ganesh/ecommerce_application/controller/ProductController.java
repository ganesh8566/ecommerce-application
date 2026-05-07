package com.ganesh.ecommerce_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	// Get Product By ID
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {

		return productService.getProductById(id);
	}

	// Delete Product
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {

		productService.deleteProduct(id);

		return "Product Deleted Successfully";
	}

	// Search Product
	@GetMapping("/search")
	public List<Product> searchProducts(@RequestParam String name) {

		return productService.searchProducts(name);
	}
}
