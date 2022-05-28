package com.asa.vaxsys.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The type App secret key.
 */
@Getter
@Setter
@Builder
public class AppSecretKey {

    private String key;
    private String secret;
}
