package com.asa.vaxsys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Vaccine Details Model
 */
@Entity
@Table(name = "vaccine_details")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaccineDetails extends BaseModel{

	@JsonProperty("name")
	@Column(unique = true)
    private String name;

    @JsonProperty("eligibility_age_start")
    private Integer eligibilityAgeStart;
    
    @JsonProperty("eligibility_age_end")
    private Integer eligibilityAgeEnd;

    @JsonProperty("number_of_doses")
    private Integer numberOfDoses;
    
    @JsonProperty("description")
    @Column(columnDefinition="text")
    private String description;

    @JsonProperty("applicable_disease")
    private String applicableDisease;

    @JsonProperty("vaccine_type")
    private String vaccine_type;
    
}
