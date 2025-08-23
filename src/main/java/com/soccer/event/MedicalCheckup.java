package com.soccer.event;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
public class MedicalCheckup {
    private Date date;
    private String doctorName;
    private String notes;

    public MedicalCheckup(Date date, String doctorName, String notes) {
        this.date = date;
        this.doctorName = doctorName;
        this.notes = notes;
    }
    public void displayMedicalCheckup() {
        System.out.println("Medical Checkup: {" + " Date: " + date + " ,Doctor Name: " + doctorName + " ,Notes: " + notes+" }");
    }
}
