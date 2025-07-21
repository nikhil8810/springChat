package com.app.chat.service;

import com.app.chat.dto.UserRequest;
import com.app.chat.dto.UserResponse;
import com.app.chat.model.User;
import com.app.chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    
    public UserResponse createUser(UserRequest userRequest) {
        // Check if username already exists
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        
        // Check if email already exists
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        
        // Create new user
        User user = new User(
            userRequest.getUsername(),
            userRequest.getEmail(),
            userRequest.getPassword()
        );
        
        User savedUser = userRepository.save(user);
        return convertToUserResponse(savedUser);
    }
    
    public UserResponse getUserById(String id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToUserResponse(user);
    }
    
    public UserResponse getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToUserResponse(user);
    }
    
    private UserResponse convertToUserResponse(User user) {
        return new UserResponse(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getCreatedAt(),
            user.isActive()
        );
    }
} 