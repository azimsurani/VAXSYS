package com.asa.vaxsys.repository;

import com.asa.vaxsys.entity.Appointment;
import com.asa.vaxsys.entity.availableAppointments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface availableAppointmentsRepository extends CrudRepository<availableAppointments,Integer> {
    List<availableAppointments> findByDateAndTime(String date, String time);//Method definition
}