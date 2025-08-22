package com.soccer.repository;

import com.soccer.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeamRepo extends MongoRepository<Team, String> {
    Optional<Team> findById(String id);
}
