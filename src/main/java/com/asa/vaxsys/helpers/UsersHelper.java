package com.asa.vaxsys.helpers;

import com.asa.vaxsys.dto.UserAuthenticationRequestDto;
import com.asa.vaxsys.dto.UserCreationRequestDto;
import com.asa.vaxsys.entity.User;
import com.asa.vaxsys.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * The type Users helper.
 */
@Service
public class UsersHelper {

    private UsersService usersService;

    /**
     * Instantiates a new Users helper.
     *
     * @param usersService the users service
     */
    @Autowired
    public UsersHelper(UsersService usersService){
        this.usersService = usersService;
    }

    /**
     * Register user user.
     *
     * @param userCreationRequestDto the user creation request dto
     * @return the user
     */
    public User registerUser(UserCreationRequestDto userCreationRequestDto){
        return usersService.createUser(userCreationRequestDto.getName(),
                userCreationRequestDto.getEmailAddress(),
                userCreationRequestDto.getPassword(),
                userCreationRequestDto.getPhoneNumber(),
                userCreationRequestDto.getUserType());
    }

    public boolean authenticateUser(UserAuthenticationRequestDto userAuthenticationRequestDto){
        User user = usersService.findUser(userAuthenticationRequestDto.getEmailAddress(), userAuthenticationRequestDto.getPassword());
        return Objects.nonNull(user);
    }

}
