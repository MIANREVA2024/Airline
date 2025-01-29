package com.reyestech24.Airline.Register;

import java.util.HashMap;
import java.util.Map;

import com.reyestech24.Airline.User.User;
import com.reyestech24.Airline.User.UserDTO;
import com.reyestech24.Airline.User.UserRepository;
import com.reyestech24.Airline.facade.encryptions.IEncryptFacade;
import com.reyestech24.Airline.roles.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final IEncryptFacade encryptFacade;

    public RegisterService(UserRepository userRepository, RoleService roleService, IEncryptFacade encryptFacade) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.encryptFacade = encryptFacade;
    }

    public Map<String, String> save(UserDTO userData) {

        String passwordDecoded = encryptFacade.decode("base64",userData.password());

        System.out.println("<------------ " + passwordDecoded);

        String passwordEncoded = encryptFacade.encode("bcrypt", passwordDecoded);

        User newUser = new User(userData.username(), passwordEncoded);
        newUser.setRoles(roleService.assignDefaultRole());

        userRepository.save(newUser);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Success");

        return response;
    }

}