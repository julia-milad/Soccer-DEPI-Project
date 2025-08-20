package com.soccer.model;

import com.soccer.event.TrainingSession;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Team {

    @Id
    private String id;
    private String name;
    private String coachId;
    private ArrayList<String> players;
    private ArrayList<TrainingSession> trainingHistory;

    public void addPlayer(String player) {
        players.add(player);
    }

    public void scheduleTraining(TrainingSession session) {
        trainingHistory.add(session);
    }
}
