package com.soccer.model;

import com.soccer.event.TrainingSession;
import com.soccer.repository.PlayerRepo;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
@Service
@Document(collection = "Coaches")
public class Coach extends Person {

    @Autowired
    private PlayerRepo playerRepo;

    public Coach(){
        super.role = "Coach";
    }

    public void updatePlayerByEmail(Coach coach, String playerEmail, String position) {
        Player player = playerRepo.findByEmailAndTeamId(playerEmail, coach.getTeamId());
        if (player != null) {
            player.setPosition(position);
            playerRepo.save(player);
            System.out.println("Updated player " + player.getName() + " to: " + position);
        } else {
            System.out.println("Player with Email " + playerEmail + " not found in this team.");
        }
    }
}