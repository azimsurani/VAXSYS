package com.asa.vaxsys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VaccineCenterRequestDTO {
	
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
