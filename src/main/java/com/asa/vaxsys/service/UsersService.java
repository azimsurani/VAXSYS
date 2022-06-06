package com.asa.vaxsys.service;

import com.asa.vaxsys.entity.User;
import com.asa.vaxsys.enums.UserType;
import com.asa.vaxsys.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * The type Users service.
 */
@Service
public class UsersService {

    private UserRepository userRepository;

    /**
     * Instantiates a new Users service.
     *
     * @param userRepository the user repository
     */
    public UsersService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Create user user.
     *
     * @param name         the name
     * @param emailAddress the email address
     * @param password     the password
     * @param phoneNumber  the phone number
     * @param userType     the user type
     * @return the user
     */
    public User createUser(String name, String emailAddress, String password, Long phoneNumber, String userType){
        User user = User.builder()
                .emailAddress(emailAddress)
                .name(name)
                .password(password)
                .phoneNumber(phoneNumber)
                .userType(UserType.getUserType(userType))
                .build();
        userRepository.save(user);
        return user;
    }

    public User findUser(String emailAddress, String password){
        return userRepository.findFirstByEmailAddressAndPassword(emailAddress, password);
    }

}
