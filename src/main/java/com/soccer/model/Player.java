package com.soccer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "Players")
public class Player extends Person {

    private String position;
    private Stats stats;
    private Fitness fitness;
    private boolean injured;


}