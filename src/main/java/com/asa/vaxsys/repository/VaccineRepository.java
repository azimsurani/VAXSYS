package com.asa.vaxsys.repository;

import org.springframework.data.repository.CrudRepository;

import com.asa.vaxsys.entity.VaccineDetails;

/**
 * The interface Vaccine repository.
 */
public interface VaccineRepository extends CrudRepository<VaccineDetails, Integer> {



}
