package com.asa.vaxsys.service;

import org.springframework.stereotype.Service;

import com.asa.vaxsys.entity.VaccineDetails;
import com.asa.vaxsys.repository.VaccineRepository;

@Service
public class VaccineService {
	
	private VaccineRepository vaccineRepository;

    /**
     * Instantiates a new Vaccine service.
     *
     * @param vaccineRepository the vaccine repository
     */
    public VaccineService(VaccineRepository vaccineRepository){
        this.vaccineRepository = vaccineRepository;
    }
    	
    
    /**
     * Create new vaccine
     * @param name
     * @param eligibilityAgeStart
     * @param eligibilityAgeEnd
     * @param numberOfDoses
     * @param description
     * @param applicableDisease
     * @param vaccine_type
     * @return VaccineDetails
     */
    public VaccineDetails createVaccine(String name, Integer eligibilityAgeStart,Integer eligibilityAgeEnd,
    		Integer numberOfDoses, String description,String applicableDisease,String vaccine_type){
    	
    	VaccineDetails vaccineDetails = VaccineDetails.builder()
    			.name(name)
    			.eligibilityAgeStart(eligibilityAgeStart)
    			.eligibilityAgeEnd(eligibilityAgeEnd)
    			.numberOfDoses(numberOfDoses)
    			.description(description)
    			.applicableDisease(applicableDisease)
    			.vaccine_type(vaccine_type)
                .build();
    	
    	vaccineRepository.save(vaccineDetails);
    	
        return vaccineDetails;
    }

}
