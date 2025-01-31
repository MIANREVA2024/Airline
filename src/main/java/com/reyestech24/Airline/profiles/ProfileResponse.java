package com.reyestech24.Airline.profiles;

public record ProfileResponse(
        Long profileId,
        String name,
        String phone,
        String email,
        String picture,
        Long userId
) {
}