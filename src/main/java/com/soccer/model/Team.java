package com.soccer.model;

import com.soccer.event.TrainingSession;

import java.util.ArrayList;

public class Team {
    private String name;
    private Coach coach;
    private ArrayList<Player> players;
    private ArrayList<TrainingSession> trainingHistory;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void scheduleTraining(TrainingSession session) {
        trainingHistory.add(session);
    }
}
