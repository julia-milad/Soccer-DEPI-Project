package com.soccer.event;

import com.soccer.model.Player;
import com.soccer.model.Team;

import java.util.ArrayList;

public class TrainingManagementSystem {
    private ArrayList<Team> teams;

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void generateReport(Player player) {
        // create a performance report for the player
    }
}
