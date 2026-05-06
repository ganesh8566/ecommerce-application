package com.ganesh.ecommerce_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.ecommerce_application.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
