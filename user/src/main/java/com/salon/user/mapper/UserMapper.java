package com.salon.user.mapper;

import com.salon.user.dto.UserRequest;
import com.salon.user.dto.UserResponse;
import com.salon.user.models.User;

import java.time.LocalDateTime;

public class UserMapper {


    public static UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),

                user.getFullName(),
                user.getEmail(),
                user.getPhone(),
                user.getCreatedAt(),
                user.getRole().name()
        );
    }

    public static User toUser(UserRequest userRequest) {
        User user= new User();
        user.setCreatedAt(LocalDateTime.now());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhone(userRequest.getPhone());
        user.setUsername(user.getUsername());
        user.setRole(user.getRole());
        user.setFullName(userRequest.getFullName());
        return user;
    }
}
