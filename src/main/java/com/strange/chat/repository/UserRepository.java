package com.strange.chat.repository;

import com.strange.chat.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // Optionally add custom query methods here
} 