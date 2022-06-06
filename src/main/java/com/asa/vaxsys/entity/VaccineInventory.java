package com.asa.vaxsys.entity;

import com.asa.vaxsys.enums.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The type Inventory.
 */
@Entity
@Table(name = "vaccine_inventory")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaccineInventory extends BaseModel{

    @JsonProperty("id")
    @Column(unique = true)
    private Integer id;

    @JsonProperty("centre_id")
    @Column(unique = true)
    private Integer vaccination_centre_id;

    @JsonProperty("vaccine_detail_id")
    @Column(unique = true)
    private Integer vaccination_detail_id;

    @JsonProperty("total_stock")
    private Long stock_available;


}
