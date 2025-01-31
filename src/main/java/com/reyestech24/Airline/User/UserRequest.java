package com.reyestech24.Airline.User;


import com.reyestech24.Airline.roles.Role;

public record UserRequest(String username, String password, Role role) {
}