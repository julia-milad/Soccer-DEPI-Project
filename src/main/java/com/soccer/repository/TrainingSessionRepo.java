package com.soccer.repository;

import com.soccer.event.TrainingSession;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TrainingSessionRepo extends MongoRepository<TrainingSession, String> {
    List<TrainingSession> findByCoachName(String coachName);
}
