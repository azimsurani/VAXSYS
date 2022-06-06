package com.asa.vaxsys.repository;

import org.springframework.data.repository.CrudRepository;

import com.asa.vaxsys.entity.VaccineCenter;

public interface VaccineCenterRepository extends CrudRepository<VaccineCenter, Integer> {

    VaccineCenter findFirstById(Integer id);

}
