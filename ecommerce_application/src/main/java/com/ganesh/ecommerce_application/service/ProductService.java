package com.ganesh.ecommerce_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.ecommerce_application.entity.Product;
import com.ganesh.ecommerce_application.exception.ResourceNotFoundException;
import com.ganesh.ecommerce_application.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// Add Product
	public Product addProduct(Product product) {

		return productRepository.save(product);
	}

	// Get All Products
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	// Get Product By ID
	public Product getProductById(Long id) {

		Optional<Product> optionalProduct = productRepository.findById(id);

		return optionalProduct.orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));
	}

	// Delete Product
	public void deleteProduct(Long id) {

		productRepository.deleteById(id);
	}

	// Search Product
	public List<Product> searchProducts(String name) {

		return productRepository.findByNameContaining(name);
	}
}
