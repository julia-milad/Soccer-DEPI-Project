package com.soccer.model;

import com.soccer.event.TrainingSession;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Coaches")
public class Coach extends Person {

    private List<TrainingSession> sessions = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
}
