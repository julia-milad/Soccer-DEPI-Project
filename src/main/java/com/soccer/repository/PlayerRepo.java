package com.soccer.repository;

import com.soccer.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface PlayerRepo extends MongoRepository<Player, String> {
    Optional<Player> findByEmail(String email);
}
