package com.asa.vaxsys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

/**
 * The type User creation response dto.
 */
@Getter
@Builder
@AllArgsConstructor
public class UserCreationResponseDto implements Serializable {

    @JsonProperty("user_creation_result")
    private boolean userCreationResult;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("name")
    private String name;

}
