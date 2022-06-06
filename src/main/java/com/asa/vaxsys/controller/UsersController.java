package com.asa.vaxsys.controller;

import com.asa.vaxsys.constants.UriConstants;
import com.asa.vaxsys.dto.*;
import com.asa.vaxsys.entity.User;
import com.asa.vaxsys.helpers.UsersHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * The type Users controller.
 */
@Service
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersHelper usersHelper;

    /**
     * Instantiates a new Users controller.
     *
     * @param usersHelper the users helper
     */
    @Autowired
    public UsersController(UsersHelper usersHelper){
        this.usersHelper = usersHelper;
    }

    @RequestMapping(method = RequestMethod.POST, value = UriConstants.registerUser)
    private ResponseDto<UserCreationResponseDto> registerUser(@RequestBody UserCreationRequestDto userCreationRequestDto){
        User user = usersHelper.registerUser(userCreationRequestDto);
        if(user != null) {
            return new ResponseDto<>(UserCreationResponseDto.builder().userCreationResult(true)
                    .name(user.getName())
                    .emailAddress(user.getEmailAddress())
                    .build());
        }
        else {
            return new ResponseDto<>(UserCreationResponseDto.builder().userCreationResult(false).build());
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = UriConstants.authenticateUser)
    private ResponseDto<UserAuthenticationResponseDto> authenticateUser(@RequestBody UserAuthenticationRequestDto userAuthenticationRequestDto){
        boolean authentication = usersHelper.authenticateUser(userAuthenticationRequestDto);
        return new ResponseDto<>(UserAuthenticationResponseDto.builder().authentication(authentication).build());
    }


}
