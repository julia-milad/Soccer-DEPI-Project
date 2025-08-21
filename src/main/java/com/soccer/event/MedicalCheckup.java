package com.soccer.event;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class MedicalCheckup {
    private Date date;
    private String doctorName;
    private String notes;



}
