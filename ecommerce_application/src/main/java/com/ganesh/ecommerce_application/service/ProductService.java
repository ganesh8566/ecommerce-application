package com.ganesh.ecommerce_application.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.ecommerce_application.entity.Product;
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
}
