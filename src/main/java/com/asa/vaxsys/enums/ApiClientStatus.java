package com.asa.vaxsys.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Api client status.
 */
@AllArgsConstructor
@Getter
public enum ApiClientStatus {

    /**
     * Active api client status.
     */
    Active(0),

    /**
     * Inactive api client status.
     */
    Inactive(1);

    private Integer statusId;
}
