package com.asa.vaxsys.entity;

import com.asa.vaxsys.enums.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The type User.
 */
@Entity
@Table(name = "users")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel{

    @JsonProperty("name")
    private String name;

    @JsonProperty("email_address")
    @Column(unique = true)
    private String emailAddress;

    @JsonProperty("password")
    private String password;

    @Column(unique = true)
    @JsonProperty("phone_number")
    private Long phoneNumber;

    @JsonProperty("user_type")
    private UserType userType;

}
