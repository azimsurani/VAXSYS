package com.asa.vaxsys.service;

import com.asa.vaxsys.dto.allAppointmentsDIsplayDto;
import com.asa.vaxsys.dto.bookAppointmentResponseDto;
import com.asa.vaxsys.entity.Appointment;
import com.asa.vaxsys.entity.User;
import com.asa.vaxsys.entity.availableAppointments;
import com.asa.vaxsys.repository.AppRepository;
import com.asa.vaxsys.repository.UserRepository;
import com.asa.vaxsys.repository.availableAppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    @Autowired
//    AppRepository repository;
    availableAppointmentsRepository availableAppointmentsRepository;

    @Autowired
    AppRepository appointmentRep ;

    public List<allAppointmentsDIsplayDto> getAllAppointments()
    {
        availableAppointments availableAppointments = new availableAppointments();
        availableAppointmentsRepository.save(availableAppointments);

        return ((List <availableAppointments>) availableAppointmentsRepository.findAll()).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private allAppointmentsDIsplayDto convertToDto(availableAppointments a)
    {
        allAppointmentsDIsplayDto dto = new allAppointmentsDIsplayDto();
        dto.setDate(a.getDate());
        dto.setNumOfDoses(a.getNumOfDoses());
//        dto.setVaccineCenter_id (a.getVaccineCentre_id());
        return dto;
    }

    public List<bookAppointmentResponseDto> bookAppointment(String date,String time,int userID, int vaccineCentre_id,int vaccineID)
    {
//        List<availableAppointments> appointments = availableAppointmentsRepository.findByDateAndTime(date,time);
//        availableAppointments appointmentId =   appointments.remove(0);
//        availableAppointmentsRepository.deleteById(appointmentId.getId());
        addAppointment(date,time,userID,vaccineCentre_id,vaccineID);


        return ((List<availableAppointments>)availableAppointmentsRepository.findByDateAndTime(date,time)).stream().map(this::convertToResponseDto).collect(Collectors.toList());
    }

    private bookAppointmentResponseDto convertToResponseDto(availableAppointments a){
        bookAppointmentResponseDto dto = new bookAppointmentResponseDto();
        dto.setMessage("booked");
        return dto;
    }

    public void addAppointment(String date,String time,int userID, int vaccineCentre_id,int vaccineID)
    {
        Appointment a= new Appointment();
        a.setDate(date);
        a.setTime(time);
        a.setUserID(userID);
        a.setVaccine_center_id(vaccineCentre_id);
        a.setVaccine_detail_id(vaccineID);
        appointmentRep.save(a);
    }


}

