package com.asa.vaxsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asa.vaxsys.constants.UriConstants;
import com.asa.vaxsys.dto.ResponseDto;
import com.asa.vaxsys.dto.VaccineCreationResponseDto;
import com.asa.vaxsys.dto.VaccineCreationRequestDto;
import com.asa.vaxsys.entity.VaccineDetails;
import com.asa.vaxsys.helpers.VaccineHelper;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {
	
	
	private final VaccineHelper vaccineHelper;
	
	/**
     * Instantiates a new Vaccine controller.
     *
     * @param vaccineHelper the vaccine helper
     */
    @Autowired
    public VaccineController(VaccineHelper vaccineHelper){
        this.vaccineHelper = vaccineHelper;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = UriConstants.CREATE)
    private ResponseDto<VaccineCreationResponseDto> createVaccine(@RequestBody VaccineCreationRequestDto vaccineCreationRequestDto){
        
    	VaccineDetails vaccineDetails = vaccineHelper.createVaccine(vaccineCreationRequestDto);
    	
        if(vaccineDetails != null) {
        	
            return new ResponseDto<>(VaccineCreationResponseDto.builder()
            		.vaccineCreationResult(true)
            		.name(vaccineDetails.getName())
            		.description(vaccineDetails.getDescription())
            		.eligibilityAgeStart(vaccineDetails.getEligibilityAgeStart())
            		.eligibilityAgeEnd(vaccineDetails.getEligibilityAgeEnd())
            		.vaccineType(vaccineDetails.getVaccine_type())
            		.numberOfDoses(vaccineDetails.getNumberOfDoses())
            		.build());
            		
        }
        else {
            return new ResponseDto<>(VaccineCreationResponseDto.builder().vaccineCreationResult(false).build());
        }
    }
	

}
