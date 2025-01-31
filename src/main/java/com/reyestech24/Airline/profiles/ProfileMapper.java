package com.reyestech24.Airline.profiles;

import com.reyestech24.Airline.User.User;
import jakarta.validation.Valid;


public class ProfileMapper {
    public static Profile toEntity(@Valid ProfileRequest profileRequest, User user){
        return new Profile(
                profileRequest.name(),
                profileRequest.phone(),
                profileRequest.email(),
                profileRequest.picture(),
                user
        );
    }

    public static ProfileResponse toResponse(Profile profile){
        return new ProfileResponse(
                profile.getProfileId(),
                profile.getName(),
                profile.getPhone(),
                profile.getEmail(),
                profile.getPicture(),
                profile.getUser().getId()
        );
    }

}