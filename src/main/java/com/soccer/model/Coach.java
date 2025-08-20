package com.soccer.model;

import com.soccer.event.TrainingSession;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Coaches")
public class Coach extends Person {

    public void planTraining(TrainingSession session) {

    }


}
