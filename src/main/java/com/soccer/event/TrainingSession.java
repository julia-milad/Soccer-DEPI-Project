package com.soccer.event;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "TrainingSessions")
public class TrainingSession {

    @Id
    private String id;
    private String date;
    private String focusArea;
    private String drillDescription;
    private String coachName;
    private String teamName;

}
