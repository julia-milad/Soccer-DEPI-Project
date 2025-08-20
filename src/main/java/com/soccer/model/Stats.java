package com.soccer.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Stats {
    private int goals;
    private int assists;
    private int passesCompleted;
    private double distanceCovered;

}
