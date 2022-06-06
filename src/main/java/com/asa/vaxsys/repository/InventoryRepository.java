package com.asa.vaxsys.repository;

import com.asa.vaxsys.entity.User;
import com.asa.vaxsys.entity.VaccineInventory;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface User repository.
 */
public interface InventoryRepository extends CrudRepository<VaccineInventory, Integer> {



}
