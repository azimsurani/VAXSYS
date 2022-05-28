package com.asa.vaxsys.enums;

import com.asa.vaxsys.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * The enum User type.
 */
@AllArgsConstructor
@Getter
public enum UserType {

    /**
     * Admin user type.
     */
    ADMIN(0, "admin"),

    /**
     * End user user type.
     */
    END_USER(1, "end_user"),

    /**
     * Health worker user type.
     */
    HEALTH_WORKER(2, "health_worker");

    private Integer userStatusType;
    private String userType;

    private static final Map<String, UserType> userTypeMap = new HashMap<>();

    static {
        for(UserType value : UserType.values()){
            userTypeMap.put(value.getUserType(), value);
        }
    }

    /**
     * Get user type user type.
     *
     * @param userType the user type
     * @return the user type
     */
    public static UserType getUserType(String userType){
        return userTypeMap.get(userType);
    }


}