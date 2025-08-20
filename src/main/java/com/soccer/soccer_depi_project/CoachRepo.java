package com.soccer.soccer_depi_project;

import com.soccer.model.Coach;
import com.soccer.model.Person;
import com.soccer.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CoachRepo extends MongoRepository<Coach, String> {
    Optional<Coach> findByEmail(String email);
}
