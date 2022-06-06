package com.asa.vaxsys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The type Inventory creation request dto.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VaccineInventoryCreationRequestdto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("centre_id")
    private Integer vaccination_centre_id;

    @JsonProperty("vaccine_detail_id")
    private Integer vaccination_detail_id;

    @JsonProperty("total_stock")
    private Long stock_available;



}
