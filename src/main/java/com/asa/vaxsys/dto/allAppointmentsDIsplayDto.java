package com.asa.vaxsys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class allAppointmentsDIsplayDto implements Serializable {


    @JsonProperty("date")
    private String date;

//    @JsonProperty("vaccineCentre")
    private int vaccineCenter_id;

    @JsonProperty("numOfDoses")
    private int numOfDoses;

    @JsonProperty("Time")
    private String time;

}
