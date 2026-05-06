package com.ganesh.ecommerce_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ganesh.ecommerce_application.entity.User;
import com.ganesh.ecommerce_application.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Register User
    public User registerUser(User user) {

        // Encrypt password before saving
        String encryptedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encryptedPassword);

        return userRepository.save(user);
    }

    // Login User
    public User loginUser(String email, String password) {

        User user = userRepository.findByEmail(email);

        if(user != null &&
           passwordEncoder.matches(password, user.getPassword())) {

            return user;
        }

        return null;
    }
}

