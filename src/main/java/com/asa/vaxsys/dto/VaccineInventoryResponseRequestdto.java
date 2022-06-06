package com.asa.vaxsys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

/**
 * The type Inventory creation response dto.
 */
@Getter
@Builder
@AllArgsConstructor
public class VaccineInventoryResponseRequestdto implements Serializable {

    @JsonProperty("inventory_creation_result")
    private boolean inventoryCreationResult;

    @JsonProperty("centre_id")
    private Integer vaccination_centre_id;

    @JsonProperty("vaccine_detail_id")
    private Integer vaccination_detail_id;

    @JsonProperty("total_stock")
    private Long stock_available;

}
