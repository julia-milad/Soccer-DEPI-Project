package com.soccer.event;
import java.util.Date;

public class Injury {
    private String type;       // e.g., "Hamstring", "Knee"
    private Date injuryDate;
    private Date expectedRecoveryDate;
    private boolean recovered;

    public Injury(String type, Date injuryDate, Date expectedRecoveryDate) {
        this.type = type;
        this.injuryDate = injuryDate;
        this.expectedRecoveryDate = expectedRecoveryDate;
        this.recovered = false;
    }

    public void markRecovered() {
        this.recovered = true;
    }


}
