package com.asa.vaxsys.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.asa.vaxsys.entity.Appointment;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AppRepository extends JpaRepository<Appointment, Date> {

}
