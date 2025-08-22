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

    public void addPlayer(Player player) {
        players.add(player);
    }
    public void addTeam(Team team) {
        teams.add(team);
    }
    public void addCoach(Coach coach) {
        coaches.add(coach);
    }
    public Team findTeamById(String teamId) {
        return teams.stream()
                .filter(t -> t.getId().equals(teamId))
                .findFirst()
                .orElse(null);
    }

    public Player findPlayerById(String playerId) {
        return players.stream()
                .filter(p -> p.getId().equals(playerId))
                .findFirst()
                .orElse(null);
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

//    public List<TrainingSession> getSessionsByCoach(String coachId) {
//        return trainingSessions.stream()
//                .filter(s -> s.getCoach() != null && s.getCoach().getId().equals(coachId))
//                .toList();
//    }

//    public List<TrainingSession> getSessionsByPlayer(String playerId) {
//        return trainingSessions.stream()
//                .filter(s -> s.getParticipants().stream().anyMatch(p -> p.getId().equals(playerId)))
//                .toList();
//    }

    // ------------------ Reports ------------------ //
//    public String generatePlayerReport(String playerId) {
//        Player player = findPlayerById(playerId);
//        if (player == null) return "Player not found.";
//
//        StringBuilder report = new StringBuilder();
//        report.append("Report for Player: ").append(player.getName()).append("\n");
//        report.append("Team: ").append(player.getTeamId()).append("\n");
//        report.append("Sessions attended: \n");
//
//        trainingSessions.stream()
//                .filter(s -> s.getParticipants().stream().anyMatch(p -> p.getId().equals(playerId)))
//                .forEach(s -> report.append("- ").append(s.sessionSummary()).append("\n"));
//
//        return report.toString();
//    }
}
