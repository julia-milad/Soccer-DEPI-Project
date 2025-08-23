package com.soccer.model;

import lombok.*;

@Data
@Getter
@Setter
public class Fitness {
    private double stamina;
    private double speed;
    private double strength;
    private double agility;

    public Fitness(double stamina, double speed, double strength, double agility) {
        this.stamina = stamina;
        this.speed = speed;
        this.strength = strength;
        this.agility = agility;
    }
    public void displayFitness() {
        System.out.println("Fitness:{" +"Stamina: " + stamina + "Speed: " + speed + "Strength: " + strength + "Agility: " + agility + "}");
    }
}