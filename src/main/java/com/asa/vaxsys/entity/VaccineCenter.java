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
 * Vaccine Center Model
 */
@Entity
@Table(name = "vaccine_center")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaccineCenter extends BaseModel{
	
	@JsonProperty("name")
	@Column(unique = true)
    private String name;

    @JsonProperty("contact_number")
    private Integer contactNumber;
     
    @JsonProperty("description")
    @Column(columnDefinition="text")
    private String address;

    @JsonProperty("working_hours")
    private String workingHours;
    
    @JsonProperty("working_days")
    private String workingDays;
    
}
