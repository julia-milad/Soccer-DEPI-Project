package com.soccer.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter

@Document(collection = "Coaches")
public class Coach extends Person {

    public Coach() {
        super.role = "Coach";
    }

    public void displayCoach() {
        System.out.println("Coach: ");
        super.displayInfo();
    }
}