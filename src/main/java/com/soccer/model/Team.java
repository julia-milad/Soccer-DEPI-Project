package com.soccer.model;

import com.soccer.event.TrainingSession;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Document(collection = "Teams")
public class Team {

    @Id
    private String id;
    private String name;
    private String coachName;
    private ArrayList<String> playersIds;
    private ArrayList<TrainingSession> trainingHistory;

    public void addPlayer(String playerId) {
        this.playersIds.add(playerId);
    }

    public void removePlayer(String playerId) {
        this.playersIds.remove(playerId);
    }

    public boolean isExistPlayer(String playerId) {
        return this.playersIds.contains(playerId);
    }
    public void scheduleTraining(TrainingSession session) {
        trainingHistory.add(session);
    }
    public String teamInfo() {
        return "Team: " + name +
                " | Coach ID: " + coachName +
                " | Players: " + (playersIds != null ? playersIds.size() : 0);
    }

}
