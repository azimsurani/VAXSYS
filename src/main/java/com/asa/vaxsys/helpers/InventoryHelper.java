package com.asa.vaxsys.helpers;

import com.asa.vaxsys.dto.VaccineInventoryCreationRequestdto;
import com.asa.vaxsys.entity.VaccineInventory;
import com.asa.vaxsys.service.InventoryService;
import com.asa.vaxsys.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Vaccine Inventory helper.
 */
@Service
public class InventoryHelper {

    private InventoryService inventoryService;

    /**
     * Instantiates a new inventory helper.
     *
     * @param inventoryService the users service
     */
    @Autowired
    public InventoryHelper(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    /**
     * Register user user.
     *
     * @param vaccineInventoryCreationRequestdto the user creation request dto
     * @return the user
     */
    public VaccineInventory registerInventory(VaccineInventoryCreationRequestdto vaccineInventoryCreationRequestdto){
        return inventoryService.createInventory(vaccineInventoryCreationRequestdto.getId(),
                vaccineInventoryCreationRequestdto.getVaccination_centre_id(),
                vaccineInventoryCreationRequestdto.getVaccination_detail_id(),
                vaccineInventoryCreationRequestdto.getStock_available()
                );
    }

}
