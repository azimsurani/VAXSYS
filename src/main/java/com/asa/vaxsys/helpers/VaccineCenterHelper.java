package com.asa.vaxsys.helpers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asa.vaxsys.dto.VaccineCenterRequestDTO;
import com.asa.vaxsys.entity.VaccineCenter;
import com.asa.vaxsys.service.VaccineCenterService;

@Service
public class VaccineCenterHelper {
	
	private VaccineCenterService vaccineCenterService;


    /**
     * Instantiates a new Vaccine helper.
     *
     * @param vaccineCenterService the vaccine service
     */
    @Autowired
    public VaccineCenterHelper(VaccineCenterService vaccineCenterService){
        this.vaccineCenterService = vaccineCenterService;
    }

    
    public VaccineCenter createVaccineCenter(VaccineCenterRequestDTO vaccineCenterRequestDTO){
    	
        return vaccineCenterService.createVaccineCenter(vaccineCenterRequestDTO.getName(), 
        		vaccineCenterRequestDTO.getContactNumber(),
        		vaccineCenterRequestDTO.getAddress(),
        		vaccineCenterRequestDTO.getWorkingHours(),
        		vaccineCenterRequestDTO.getWorkingDays()
        		);
        
    }


	public List<VaccineCenter> getAllVaccineCenters() {
		
		return vaccineCenterService.getAllVaccineCenters();
	}

}
