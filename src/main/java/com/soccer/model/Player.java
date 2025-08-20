package com.soccer.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection = "Players")
public class Player extends Person {

    private String position;
    private Stats stats;
    private Fitness fitness;
    private boolean injured;



}