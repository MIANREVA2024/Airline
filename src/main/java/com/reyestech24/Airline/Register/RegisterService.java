package com.reyestech24.Airline.Register;

import com.reyestech24.Airline.User.User;
import com.reyestech24.Airline.User.UserRepository;
import com.reyestech24.Airline.User.UserRequest;
import com.reyestech24.Airline.exceptions.AirlineAlreadyExistsException;
import com.reyestech24.Airline.profiles.Profile;
import com.reyestech24.Airline.profiles.ProfileService;
import com.reyestech24.Airline.roles.RoleService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Base64.Decoder;

@Service
public class RegisterService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ProfileService profileService;

    public RegisterService(UserRepository userRepository, RoleService roleService, ProfileService profileService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.profileService = profileService;
    }

    public Map<String, String> save(UserRequest userRequest){

        Optional<User> existingUser = userRepository.findByUsername(userRequest.username());
        if (existingUser.isPresent()){
            throw new AirlineAlreadyExistsException("The user already exist.");
        }

        Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(userRequest.password());
        String passwordDecoded = new String(decodedBytes);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordEncoded = encoder.encode(passwordDecoded);

        User newUser = new User(userRequest.username(), passwordEncoded);
        newUser.setRoles(roleService.assignDefaultRole(newUser.getId()));

        Profile profile = new Profile();
        profile.setUser(newUser);

        String defaultPicture = "utils/erDiagram.jpg";
        profile.setPicture(defaultPicture);

        newUser.setProfile(profile);

        userRepository.save(newUser);

        Map<String, String> userResponse = new HashMap<>();
        userResponse.put("message", "Success");

        return userResponse;
    }
}