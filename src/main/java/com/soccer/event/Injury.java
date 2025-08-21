package com.soccer.event;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Injury {
    private String type;
    private Date injuryDate;
    private Date expectedRecoveryDate;
    private boolean recovered;

    public void markRecovered() {
        this.recovered = true;
    }
}
