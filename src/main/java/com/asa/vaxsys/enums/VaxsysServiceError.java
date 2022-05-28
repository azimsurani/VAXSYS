package com.asa.vaxsys.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Tweak service error.
 */
@Getter
@AllArgsConstructor
public enum VaxsysServiceError {

    /**
     * The Entity not found.
     */
    ENTITY_NOT_FOUND(1, 404, "Entity not found"),

    /**
     * The Parameter missing.
     */
    PARAMETER_MISSING(2, 422, "Some parameters are missing or not in correct format");

    private final Integer code;
    private final Integer statusCode;
    private final String type;
}

