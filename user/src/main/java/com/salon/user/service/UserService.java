package com.salon.user.service;

import com.salon.user.dto.UserRequest;
import com.salon.user.dto.UserResponse;
import com.salon.user.dto.UserUpdateRequest;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse updateUser(Long id, UserUpdateRequest userUpdateRequest);

    void deleteUserById(Long id);
}
