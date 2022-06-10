package com.asa.vaxsys.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "availableAppointment")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class availableAppointments extends BaseModel {
//    @Column(unique = true)
//    @JsonProperty("ID")
//    int id;
    @JsonProperty("date")
    String date;

//    @JsonProperty("vaccineCentre")
//    int vaccineCentre_id;

    @JsonProperty("numOfDoses")
    int numOfDoses;

    @JsonProperty("Time")
    private String time;
}
