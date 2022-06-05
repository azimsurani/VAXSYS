package com.asa.vaxsys.helpers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asa.vaxsys.dto.VaccineCreationRequestDto;
import com.asa.vaxsys.entity.VaccineDetails;
import com.asa.vaxsys.service.VaccineService;

@Service
public class VaccineHelper {
	
	private VaccineService vaccineService;


    /**
     * Instantiates a new Vaccine helper.
     *
     * @param vaccineService the vaccine service
     */
    @Autowired
    public VaccineHelper(VaccineService vaccineService){
        this.vaccineService = vaccineService;
    }

    
    public VaccineDetails createVaccine(VaccineCreationRequestDto vaccineCreationRequestDto){
    	
        return vaccineService.createVaccine(vaccineCreationRequestDto.getName(), 
        		vaccineCreationRequestDto.getEligibilityAgeStart(), 
        		vaccineCreationRequestDto.getEligibilityAgeEnd(),
        		vaccineCreationRequestDto.getNumberOfDoses(),
        		vaccineCreationRequestDto.getDescription(),
        		vaccineCreationRequestDto.getApplicableDisease(),
        		vaccineCreationRequestDto.getVaccine_type());
        
    }


	public List<VaccineDetails> getAllVaccineDetails() {
		
		return vaccineService.getAllVaccineDetails();
	}

}
