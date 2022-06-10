package com.asa.vaxsys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class bookAppointmentRequestDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("userID")
    private int userID;

    @JsonProperty("vaccine_date")
    private String vaccine_date;

    @JsonProperty("Time")
    private String time;

    private int vaccine_id;

    private int vaccineCenter_id;
}
