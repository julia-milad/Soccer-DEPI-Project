package com.soccer.repository;

import com.soccer.model.Coach;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CoachRepo extends MongoRepository<Coach, String> {
    Optional<Coach> findByEmail(String email);
}
