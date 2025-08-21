package com.soccer.event;

import com.soccer.model.Team;
import com.soccer.model.Player;
import com.soccer.model.Coach;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TrainingManagementSystem {

    private List<Team> teams = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private List<Coach> coaches = new ArrayList<>();
    private List<TrainingSession> trainingSessions = new ArrayList<>();

    public void addTeam(Team team) {
        teams.add(team);
    }
    public Team findTeamById(String teamId) {
        return teams.stream()
                .filter(t -> t.getId().equals(teamId))
                .findFirst()
                .orElse(null);
    }
    public void addPlayer(Player player) {
        players.add(player);
    }
    public Player findPlayerById(String playerId) {
        return players.stream()
                .filter(p -> p.getId().equals(playerId))
                .findFirst()
                .orElse(null);
    }
    public void addCoach(Coach coach) {
        coaches.add(coach);
    }
    public Coach findCoachById(String coachId) {
        return coaches.stream()
                .filter(c -> c.getId().equals(coachId))
                .findFirst()
                .orElse(null);
    }

    public void addTrainingSession(TrainingSession session) {
        trainingSessions.add(session);
    }

}
