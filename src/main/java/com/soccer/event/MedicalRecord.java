package com.soccer.event;
import com.soccer.model.Player;
import lombok.*;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class MedicalRecord {
    private Player player;
    private ArrayList<Injury> injuryHistory;
    private ArrayList<MedicalCheckup> checkups;

    public MedicalRecord(Player player) {
        this.player = player;
    }

    public void addInjury(Injury injury) {
        injuryHistory.add(injury);
    }

    public void addCheckup(MedicalCheckup checkup) {
        checkups.add(checkup);
    }
}
