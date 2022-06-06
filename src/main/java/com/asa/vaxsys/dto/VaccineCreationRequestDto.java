package com.asa.vaxsys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VaccineCreationRequestDto{
	
	@JsonProperty("name")
    private String name;

    @JsonProperty("eligibility_age_start")
    private Integer eligibilityAgeStart;
    
    @JsonProperty("eligibility_age_end")
    private Integer eligibilityAgeEnd;

    @JsonProperty("number_of_doses")
    private Integer numberOfDoses;
    
    @JsonProperty("description")
    private String description;

    @JsonProperty("applicable_disease")
    private String applicableDisease;

    @JsonProperty("vaccine_type")
    private String vaccine_type;

}
