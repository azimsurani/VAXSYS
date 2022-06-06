package com.asa.vaxsys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserAuthenticationRequestDto implements Serializable {

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("password")
    private String password;

}
