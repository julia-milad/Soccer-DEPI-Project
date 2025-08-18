package com.soccer.event;

import java.util.Date;

public class MedicalCheckup {
    private Date date;
    private String doctorName;
    private String notes;

    public MedicalCheckup(Date date, String doctorName, String notes) {
        this.date = date;
        this.doctorName = doctorName;
        this.notes = notes;
    }


}
