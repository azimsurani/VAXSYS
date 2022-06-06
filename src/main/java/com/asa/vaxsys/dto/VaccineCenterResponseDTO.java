package com.asa.vaxsys.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class VaccineCenterResponseDTO implements Serializable{
	
	@JsonProperty("vaccine_center_creation_result")
    private boolean vaccineCenterCreationResult;
	
	@JsonProperty("name")
    private String name;

    @JsonProperty("contact_number")
    private String contactNumber;
     
    @JsonProperty("address")
    private String address;

    @JsonProperty("working_hours")
    private String workingHours;
    
    @JsonProperty("working_days")
    private String workingDays;

}
