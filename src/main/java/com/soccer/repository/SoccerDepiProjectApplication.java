package com.soccer.repository;

import com.soccer.event.Injury;
import com.soccer.event.MedicalCheckup;
import com.soccer.event.MedicalRecord;
import com.soccer.event.TrainingManagementSystem;
import com.soccer.model.Coach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SoccerDepiProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoccerDepiProjectApplication.class, args);

        TrainingManagementSystem trainingManagementSystem = new TrainingManagementSystem();

//        Coach coach = new Coach();
//        coach.setName("AEE");
//        coach.setEmail("aee@gmail.com");
//        coach.setAge(22);
//        coach.setImage("");
//        coach.setPhone("012 098 3309");
//        coach.setTeamId("68a49432280897211e409ba2");
//        coach.updatePlayerByEmail(coach,"john@example.com","kk");

        MedicalRecord record = new MedicalRecord();
        record.setPlayerId("68a31b2eabeaffbecfcc9c57");
        Injury injury = new Injury("Sprained Ankle", new Date("05/08/2025"), new Date("15/08/2025"),true);
        record.addInjury(injury);
        MedicalCheckup checkup = new MedicalCheckup(new Date("20/08/2025"), "General Checkup", "Normal");
        record.addCheckup(checkup);
    }

}
