package com.reyestech24.Airline.Register;

import com.reyestech24.Airline.User.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "${api-endpoint}/register")
public class RegisterController {

    private final RegisterService service;

    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<Map<String,String>> register(@RequestBody UserDTO newUser) {

        Map<String, String> response = service.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
