package com.reyestech24.Airline.User;

public class UserMapper {
    public static UserDTO toDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .profileImage(user.getProfileImage())
                .build();
    }
    public static User toEntity(UserDTO userDTO){
        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .role(userDTO.getRole())
                .profileImage(userDTO.getProfileImage())
                .build();
    }
}
