package com.soccer.event;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
public class Injury {
    private String type;
    private Date injuryDate;
    private Date expectedRecoveryDate;
    private boolean recovered;

    public Injury(String type, Date injuryDate, Date expectedRecoveryDate) {
        this.type = type;
        this.injuryDate = injuryDate;
        this.expectedRecoveryDate = expectedRecoveryDate;
    }
    public void markRecovered() {
        this.recovered = true;
    }
    public void displayInjury() {
        System.out.println("Injury: {" + " Type: " +type + " ,Injury Date: " + injuryDate + " ,Expected Recovery Date: " + expectedRecoveryDate+" }");
    }
}
