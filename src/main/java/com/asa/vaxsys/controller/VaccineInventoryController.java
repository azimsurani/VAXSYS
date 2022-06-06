package com.asa.vaxsys.controller;

import com.asa.vaxsys.constants.UriConstants;
import com.asa.vaxsys.dto.*;
import com.asa.vaxsys.entity.VaccineInventory;
import com.asa.vaxsys.helpers.InventoryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Inventory controller.
 */
@Service
@RestController
@RequestMapping("/vaccine_inventory")
public class VaccineInventoryController {

    private final InventoryHelper inventoryHelper;

    /**
     * Instantiates a new Inventory controller.
     *
     * @param inventoryHelper the inventory helper
     */
    @Autowired
    public VaccineInventoryController(InventoryHelper inventoryHelper){
        this.inventoryHelper = inventoryHelper;
    }

    @RequestMapping(method = RequestMethod.POST, value = UriConstants.registerInventory)
    private ResponseDto<VaccineInventoryResponseRequestdto> register_user(@RequestBody VaccineInventoryCreationRequestdto vaccineInventoryCreationRequestdto){
        VaccineInventory inventory = inventoryHelper.registerInventory(vaccineInventoryCreationRequestdto);
        if(inventory != null) {
            return new ResponseDto<>(VaccineInventoryResponseRequestdto.builder().inventoryCreationResult(true)
                    .vaccination_centre_id(inventory.getVaccinationCentre().getId())
                    .vaccination_detail_id(inventory.getVaccinationDetail().getId())
                    .stock_available(inventory.getStock_available())
                    .build());
        }
        else {
            return new ResponseDto<>(VaccineInventoryResponseRequestdto.builder().inventoryCreationResult(false).build());
        }
    }


}
