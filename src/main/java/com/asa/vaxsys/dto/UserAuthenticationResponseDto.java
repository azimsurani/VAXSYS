package com.asa.vaxsys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserAuthenticationResponseDto implements Serializable {

    @JsonProperty("authentication")
    private Boolean authentication;

}
