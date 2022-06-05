package com.asa.vaxsys.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class VaccineCreationResponseDto implements Serializable {
	
	@JsonProperty("vaccine_creation_result")
    private boolean vaccineCreationResult;
	
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
    private String vaccineType;

}
