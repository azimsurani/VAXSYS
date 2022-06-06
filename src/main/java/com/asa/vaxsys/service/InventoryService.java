package com.asa.vaxsys.service;

import com.asa.vaxsys.entity.VaccineCenter;
import com.asa.vaxsys.entity.VaccineDetails;
import com.asa.vaxsys.entity.VaccineInventory;
import com.asa.vaxsys.repository.InventoryRepository;
import org.springframework.stereotype.Service;

/**
 * The type Vaccine Inventory service.
 */
@Service
public class InventoryService {

    private InventoryRepository inventoryRepository;

    private VaccineCenterService vaccineCenterService;

    private VaccineService vaccineService;

    /**
     * Instantiates a new Users service.
     *
     * @param inventoryRepository the user repository
     */
    public InventoryService(InventoryRepository inventoryRepository, VaccineCenterService vaccineCenterService, VaccineService vaccineService){
        this.inventoryRepository = inventoryRepository;
        this.vaccineCenterService = vaccineCenterService;
        this.vaccineService = vaccineService;
    }

    /**
     * Create user user.
     *
     * @param id        the unique id of vaccine
     * @param vaccination_centre_id the centre id
     * @param vaccination_detail_id     detail id
     * @param stock_available  the current stock count
     * @return the inventory
     */
    public VaccineInventory createInventory(Integer id, Integer vaccination_centre_id, Integer vaccination_detail_id, Long stock_available){
        VaccineCenter vaccineCenter = vaccineCenterService.findById(vaccination_centre_id);
        VaccineDetails vaccineDetails = vaccineService.findById(vaccination_detail_id);
        VaccineInventory inventory = VaccineInventory.builder()
                .id(id)
                .vaccinationCentre(vaccineCenter)
                .vaccinationDetail(vaccineDetails)
                .stock_available(stock_available)
                .build();
        inventoryRepository.save(inventory);
        return inventory;
    }

}
