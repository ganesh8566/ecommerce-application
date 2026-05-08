package com.ganesh.ecommerce_application.jwt;


import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)

			throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization");

		if (authHeader != null && authHeader.startsWith("Bearer ")) {

			String token = authHeader.substring(7);

			// Validate Token
			if (jwtUtil.validateToken(token)) {

				// Extract Email
				String email = jwtUtil.extractEmail(token);

				// Create Authentication Object
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, null,
						Collections.emptyList());

				// Set Authentication
				SecurityContextHolder.getContext().setAuthentication(authToken);

			} else {

				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

				response.getWriter().write("Invalid JWT Token");

				return;
			}
		}

		filterChain.doFilter(request, response);
	}
}