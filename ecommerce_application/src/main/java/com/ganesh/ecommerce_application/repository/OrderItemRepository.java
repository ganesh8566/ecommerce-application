package com.ganesh.ecommerce_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.ecommerce_application.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
