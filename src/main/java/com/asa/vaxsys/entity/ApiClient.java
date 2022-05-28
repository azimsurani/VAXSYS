package com.asa.vaxsys.entity;

import com.asa.vaxsys.enums.ApiClientStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * The type Api client.
 */
@Entity
@Table(name = "api_clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiClient extends BaseModel {

    @JsonProperty("client_name")
    @Column(name = "client_name")
    private String clientName;

    @JsonProperty("app_key")
    @Column(name = "app_key")
    private String appKey;

    @JsonProperty("app_secret")
    @Column(name = "app_secret")
    private String appSecret;

    @JsonProperty("status")
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ApiClientStatus status;

    @JsonProperty("permissions")
    @Column(name = "permissions")
    private String permissions;

    @JsonProperty("client_details")
    @Column(name = "client_details")
    private String clientDetails;
}
