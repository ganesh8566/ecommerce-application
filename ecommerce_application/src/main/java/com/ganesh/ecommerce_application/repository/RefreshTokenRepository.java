package com.ganesh.ecommerce_application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.ecommerce_application.entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

	Optional<RefreshToken> findByToken(String token);

	void deleteByToken(String token);
}
