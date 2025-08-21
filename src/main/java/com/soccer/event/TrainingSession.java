package com.soccer.event;

import com.soccer.model.Team;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingSession {
    @Id
    private String id;
    private String date;
    private String focusArea;
    private String drillDescription;
    private String coachId;
    private List<String> playerIds = new ArrayList<>();
    private String teamId;



    public void addPlayer(String playerId) {
        if (!playerIds.contains(playerId)) {
            playerIds.add(playerId);
        }
    }

    public String sessionSummary() {
        return "Session on " + date + " | Focus: " + focusArea + " | Drill: " + drillDescription;
    }
}
