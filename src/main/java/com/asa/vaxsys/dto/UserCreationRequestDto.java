package com.asa.vaxsys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The type User creation request dto.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequestDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("password")
    private String password;

    @JsonProperty("phone_number")
    private Long phoneNumber;

    @JsonProperty("user_type")
    private String userType;

}
