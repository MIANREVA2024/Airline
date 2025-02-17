package com.reyestech24.Airline.profiles;

import com.reyestech24.Airline.User.User;
import com.reyestech24.Airline.exceptions.AirlineAlreadyExistsException;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileRepository profileRepository;

    public ProfileController(ProfileService profileService,
                             ProfileRepository profileRepository) {
        this.profileService = profileService;
        this.profileRepository = profileRepository;
    }

    @PostMapping
    public ResponseEntity<ProfileResponse> createProfile(@RequestBody @Valid ProfileRequest profileRequest, User user) throws AirlineAlreadyExistsException {
        ProfileResponse profile = (ProfileResponse) profileService.createProfile(profileRequest, user);
        return new ResponseEntity<>(profile
                , HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ProfileResponse>> getAllProfiles(){
        List<ProfileResponse> allProfiles = profileService.getAllProfiles();
        return new ResponseEntity<>(allProfiles, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public List<ProfileResponse> getProfileByIdOrEmail(@PathVariable String email){

        try{
            Long profileId = Long.parseLong((email));
            return Collections.singletonList(profileService.findProfileById(profileId));
        } catch (NumberFormatException exception){
            return profileService.findProfileByEmail(email);
        }

    }

    @PutMapping("/{profileId}")
    public ResponseEntity<ProfileResponse> updateProfile(@PathVariable Long profileId, @RequestBody @Valid ProfileRequest profileRequest){
        ProfileResponse profileResponse = profileService.updateProfileById(profileId, profileRequest);
        return new ResponseEntity<>(profileResponse, HttpStatus.OK);
    }
}