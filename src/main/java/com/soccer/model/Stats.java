package com.soccer.model;


import lombok.*;

@Data
@Getter
@Setter
public class Stats {
    private int goals;
    private int assists;
    private int passesCompleted;
    private double distanceCovered;

    public Stats(int goals ,int assists,int passesCompleted,double distanceCovered ) {
        this.goals = goals;
        this.assists = assists;
        this.passesCompleted = passesCompleted;
        this.distanceCovered = distanceCovered;
    }
    public void displayStats() {
        System.out.println("Stats{" +"Goal : " + goals + "Assist : " + assists + "Passes : " + passesCompleted + "Distance : " + distanceCovered+'}');
    }
}
