package com.asa.vaxsys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asa.vaxsys.entity.VaccineCenter;
import com.asa.vaxsys.entity.VaccineDetails;
import com.asa.vaxsys.repository.VaccineCenterRepository;
import com.asa.vaxsys.repository.VaccineRepository;;

@Service
public class VaccineCenterService {

	private VaccineCenterRepository vaccineCenterRepository;

	public VaccineCenterService(VaccineCenterRepository vaccineCenterRepository){
		this.vaccineCenterRepository = vaccineCenterRepository;
	}

	public VaccineCenter findById(Integer id){
		return vaccineCenterRepository.findFirstById(id);
	}
	
	public VaccineCenter createVaccineCenter(String name,String contactNumber,String address,String workingHours,String workingDays){

		VaccineCenter vaccineCenter = VaccineCenter.builder()
				.name(name)
				.contactNumber(contactNumber)
				.address(address)
				.workingHours(workingHours)
				.workingDays(workingDays)
				.build();

		vaccineCenterRepository.save(vaccineCenter);

		return vaccineCenter;
	}


	public List<VaccineCenter> getAllVaccineCenters() {
		// TODO Auto-generated method stub

		List<VaccineCenter> allVaccineCenters = new ArrayList<>();

		for(VaccineCenter center : vaccineCenterRepository.findAll()) {
			allVaccineCenters.add(center);
		}

		return allVaccineCenters;
	}

}
