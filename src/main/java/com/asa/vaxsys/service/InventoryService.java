package com.asa.vaxsys.service;

import com.asa.vaxsys.entity.User;
import com.asa.vaxsys.entity.VaccineInventory;
import com.asa.vaxsys.enums.UserType;
import com.asa.vaxsys.repository.InventoryRepository;
import com.asa.vaxsys.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * The type Vaccine Inventory service.
 */
@Service
public class InventoryService {

    private InventoryRepository inventoryRepository;

    /**
     * Instantiates a new Users service.
     *
     * @param inventoryRepository the user repository
     */
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
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
        VaccineInventory inventory = VaccineInventory.builder()
                .id(id)
                .vaccination_centre_id(vaccination_centre_id)
                .vaccination_detail_id(vaccination_detail_id)
                .stock_available(stock_available)
                .build();
        inventoryRepository.save(inventory);
        return inventory;
    }

}
