package com.soccer.event;
import com.soccer.model.Player;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Document(collection = "MedicalRecords")
public class MedicalRecord {
    @Id
    private String id;

    private String playerId;
    private ArrayList<Injury> injuryHistory = new ArrayList<>();
    private ArrayList<MedicalCheckup> checkups = new ArrayList<>();

    public void addInjury(Injury injury) {
        injuryHistory.add(injury);
    }
    public void addCheckup(MedicalCheckup checkup) {
        checkups.add(checkup);
    }

}
