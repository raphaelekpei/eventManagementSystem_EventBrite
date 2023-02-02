package com.raphael.eventmanagementsystem_eventbrite.data.repository;

import com.raphael.eventmanagementsystem_eventbrite.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
