package com.asa.vaxsys.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * The type User.
 */
@Entity
@Table(name = "appointment")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment extends BaseModel{

    @JsonProperty("userID")
    private int userID;

    @JsonProperty("date")
    private String date;

    @JsonProperty("vaccine_detail_id")
    private int vaccine_detail_id;

    @JsonProperty("vaccine_center_id")
    private int vaccine_center_id;

    @JsonProperty("vaccine_date")
    private int vaccineDetails;

    @JsonProperty("DoseNumber")
    private int DoseNumber;

    @JsonProperty("Time")
    private String time;
}