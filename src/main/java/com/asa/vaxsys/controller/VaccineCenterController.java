package com.asa.vaxsys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asa.vaxsys.constants.UriConstants;
import com.asa.vaxsys.dto.ResponseDto;
import com.asa.vaxsys.dto.VaccineCenterRequestDTO;
import com.asa.vaxsys.dto.VaccineCenterResponseDTO;
import com.asa.vaxsys.entity.VaccineCenter;
import com.asa.vaxsys.helpers.VaccineCenterHelper;

@RestController
@RequestMapping("/vaccine-center")
public class VaccineCenterController {

	private final VaccineCenterHelper vaccineCenterHelper;

	/**
	 * Instantiates a new Vaccine Center controller.
	 *
	 * @param vaccineCenterHelper the vaccine center helper
	 */
	@Autowired
	public VaccineCenterController(VaccineCenterHelper vaccineCenterHelper){
		this.vaccineCenterHelper = vaccineCenterHelper;
	}

	@RequestMapping(method = RequestMethod.POST, value = UriConstants.CREATE)
	private ResponseDto<VaccineCenterResponseDTO> createVaccineCenter(@RequestBody VaccineCenterRequestDTO vaccineCenterRequestDTO){

		VaccineCenter vaccineCenter = vaccineCenterHelper.createVaccineCenter(vaccineCenterRequestDTO);

		if(vaccineCenter != null) {

			return createResponse(vaccineCenter);

		}
		else {
			return new ResponseDto<>(VaccineCenterResponseDTO.builder().vaccineCenterCreationResult(false).build());
		}
	}

	private ResponseDto<VaccineCenterResponseDTO> createResponse(VaccineCenter vaccineCenter){

		return new ResponseDto<>(VaccineCenterResponseDTO.builder()
				.vaccineCenterCreationResult(true)
				.name(vaccineCenter.getName())
				.contactNumber(vaccineCenter.getContactNumber())
				.address(vaccineCenter.getAddress())
				.workingHours(vaccineCenter.getWorkingHours())
				.workingDays(vaccineCenter.getWorkingDays())
				.build());

	}

	@RequestMapping(method = RequestMethod.GET,value = UriConstants.GET_ALL_DATA)
	private List<ResponseDto<VaccineCenterResponseDTO>> getAllVaccines(){

		List<VaccineCenter> allVaccineCenters = vaccineCenterHelper.getAllVaccineCenters();

		List<ResponseDto<VaccineCenterResponseDTO>> listOfCenters = new ArrayList<>();

		for(VaccineCenter vaccineCenter : allVaccineCenters) {

			listOfCenters.add(createResponse(vaccineCenter));

		}

		return listOfCenters;

	}


}
