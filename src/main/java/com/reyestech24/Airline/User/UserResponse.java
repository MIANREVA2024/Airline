package com.reyestech24.Airline.User;



import com.reyestech24.Airline.roles.Role;

import java.util.Set;

public record UserResponse(
        Long id,
        String username,
        String password,
        Set<Role> roles) {
}