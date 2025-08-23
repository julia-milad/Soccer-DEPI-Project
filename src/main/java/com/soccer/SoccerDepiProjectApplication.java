package com.soccer;

import com.soccer.event.Injury;
import com.soccer.event.MedicalCheckup;
import com.soccer.event.MedicalRecord;
import com.soccer.event.TrainingManagementSystem;
import com.soccer.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SoccerDepiProjectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SoccerDepiProjectApplication.class, args);
        TrainingManagementSystem tms = context.getBean(TrainingManagementSystem.class);

//        Coach coach = new Coach();
//        coach.setName("Amir Georges");
//        coach.setEmail("amir@gmail.com");
//        coach.setPassword("123");
//        coach.setAge(27);
//        coach.setImage("");
//        coach.setPhone("012 098 3309");
//        coach.setTeamId("68a49432280897211e409ba2");
//        tms.addCoach(coach);

//        Team team = new Team();
//        team.setName("Team 11");
//        team.setCoachName("Amir Georges");
//        team.setPlayersIds(new ArrayList<String>());
//        tms.addTeam(team);

//        Stats stats = new Stats(10,5,45,12.3);
//        Fitness fitness = new Fitness(8.8,9.2,7.9,8.5);
//
//        Player player = new Player();
//        player.setName("Nader Kamal");
//        player.setEmail("nader@gmail.com");
//        player.setAge(17);
//        player.setStats(stats);
//        player.setFitness(fitness);
//        player.setImage("");
//        player.setPhone("010 066 3879");
//        player.setTeamId("68a8ea52cdf6e7f6501a414c");
//        tms.addPlayer(player);

//        List<Player> allPlayers = tms.getAllPlayers();
//        for (Player p : allPlayers) {
//            p.displayPlayer();
//        }
//
//        List<Coach> allCoaches = tms.getAllCoaches();
//        for (Coach c : allCoaches) {
//            c.displayCoach();
//        }
//
//        List<Team> allTeams = tms.getAllTeams();
//        for (Team t : allTeams) {
//            t.displayTeamInfo();
//        }

//        Injury injury = new Injury("Ankle Sprain",new Date("09/07/2025"),new Date("12/08/2025"));
//        injury.markRecovered();
//
//        MedicalCheckup medicalCheckup = new MedicalCheckup(new Date("22/08/2025"),"Nagy Osama","Cleared for training, slight stiffness remains.");
//
//        MedicalRecord medicalRecord = new MedicalRecord();
//        medicalRecord.setPlayerId("68a31b2eabeaffbecfcc9c57");
//        medicalRecord.addCheckup(medicalCheckup);
//        medicalRecord.addInjury(injury);
//        tms.addMedicalRecord(medicalRecord);

//        List<MedicalRecord> allMedicalRecords = tms.getAllMedicalRecords();
//        for (MedicalRecord mr : allMedicalRecords) {
//            mr.displayMedicalRecord();
//        }
    }
}
