package com.asa.vaxsys.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


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
    @ManyToOne
    @JoinColumn(name = "vaccination_centre_id")
    private VaccineCenter vaccinationCentre;

    @JsonProperty("vaccine_detail_id")
    @ManyToOne
    @JoinColumn(name = "vaccination_detail_id")
    private VaccineDetails vaccinationDetail;

    @JsonProperty("total_stock")
    private Long stock_available;


}
