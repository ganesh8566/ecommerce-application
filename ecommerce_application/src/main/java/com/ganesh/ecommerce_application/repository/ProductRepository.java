package com.ganesh.ecommerce_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.ecommerce_application.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
