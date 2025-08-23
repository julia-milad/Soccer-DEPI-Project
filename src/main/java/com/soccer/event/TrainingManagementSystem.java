package com.soccer.event;

import com.soccer.model.Player;
import com.soccer.model.Team;
import com.soccer.model.Coach;
import com.soccer.repository.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class TrainingManagementSystem {

    private  PlayerRepo playerRepo;
    private  TeamRepo teamRepo;
    private  CoachRepo coachRepo;
    private MedicalRecordRepository medicalRecordRepo;

    public TrainingManagementSystem(PlayerRepo playerRepo, TeamRepo teamRepo, CoachRepo coachRepo, MedicalRecordRepository medicalRecordRepo) {
        this.playerRepo = playerRepo;
        this.teamRepo = teamRepo;
        this.coachRepo = coachRepo;
        this.medicalRecordRepo = medicalRecordRepo;
    }

    public void addPlayer(Player player) {
        playerRepo.save(player);
        System.out.println("Player saved to DB successfully");
    }

    public void addTeam(Team team) {
        teamRepo.save(team);
        System.out.println("Team saved to DB successfully");
    }
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordRepo.save(medicalRecord);
        System.out.println("Medical Record saved to DB successfully");
    }
    public void addCoach(Coach coach) {
        coachRepo.save(coach);
        System.out.println("Coach saved to DB successfully");
    }

    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    public List<Team> getAllTeams() {
        return teamRepo.findAll();
    }

    public List<Coach> getAllCoaches() {
        return coachRepo.findAll();
    }
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepo.findAll();
    }
}
