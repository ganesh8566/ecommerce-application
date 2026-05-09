package com.ganesh.ecommerce_application.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	// Secret Key
	private static final String SECRET_KEY = "mysecretkeymysecretkeymysecretkey12";

	private static final long EXPIRATION_TIME = 1000 * 60 * 60;

	// Generate Token
	public String generateToken(String email, String role) {

		Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

		return Jwts.builder().setSubject(email).claim("role", role).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(key, SignatureAlgorithm.HS256).compact();
	}

	// Extract Email
	public String extractEmail(String token) {

		Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
	}

	// Validate Token
	public boolean validateToken(String token) {

		try {

			Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);

			return true;

		} catch (Exception e) {

			return false;
		}
	}

	public String extractRole(String token) {

		Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().get("role",
				String.class);
	}
}
