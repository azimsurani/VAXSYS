package com.asa.vaxsys.controller;

import com.asa.vaxsys.dto.allAppointmentsDIsplayDto;
import com.asa.vaxsys.dto.bookAppointmentRequestDto;
import com.asa.vaxsys.dto.bookAppointmentResponseDto;
import com.asa.vaxsys.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService service;

    @RequestMapping(path = "/showAppointmentDetails",method=RequestMethod.GET)
    public List<allAppointmentsDIsplayDto> print()
    {
        //1Request-->List//Service vala Method.

        return service.getAllAppointments();
    }
    @RequestMapping(path="/bookAppointment",method = RequestMethod.POST)
    public List<bookAppointmentResponseDto> book(@RequestBody bookAppointmentRequestDto bookAppointmentRequestDto)
    {
        return service.bookAppointment(bookAppointmentRequestDto.getVaccine_date(),bookAppointmentRequestDto.getTime(),bookAppointmentRequestDto.getUserID(),bookAppointmentRequestDto.getVaccineCenter_id(),bookAppointmentRequestDto.getVaccine_id());
    }
}