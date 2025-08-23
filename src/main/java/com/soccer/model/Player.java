package com.soccer.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Getter
@Setter

@Document(collection = "Players")
public class Player extends Person {

    private String position;
    private Stats stats;
    private Fitness fitness;
    private boolean injured;

    public Player(){
        super.role = "Player";
    }

    public void markInjured() {
        this.injured = true;
    }

    public void recover() {
        this.injured = false;
    }

    public void displayPlayer() {
        System.out.println("Player: " + "Position: " + position + " ,Healthy: " + injured);
        super.displayInfo();
        stats.displayStats();
        fitness.displayFitness();
        System.out.println();
    }
}