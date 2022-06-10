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
public class appointmentRequestDto {
    @JsonProperty("date")
    private Date date;

    @JsonProperty("time")
    private String time;

    @JsonProperty("vaccine_id")
    private int vaccine_id;


}
