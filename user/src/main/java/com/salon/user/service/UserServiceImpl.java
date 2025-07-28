package com.salon.user.service;

import com.salon.user.dto.UserRequest;
import com.salon.user.dto.UserResponse;
import com.salon.user.dto.UserUpdateRequest;
import com.salon.user.exception.UserAlreadyExists;
import com.salon.user.exception.UserNotFoundException;
import com.salon.user.mapper.UserMapper;
import com.salon.user.models.User;
import com.salon.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(userRequest.getEmail());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExists("User with email address already exists");
        }
        User user = userRepository.save(UserMapper.toUser(userRequest));
        return UserMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> userList = userRepository
                .findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
        return userList.stream().map(UserMapper::toUserResponse).toList();
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(()->new UserNotFoundException("User Not Found"));
        return UserMapper.toUserResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserUpdateRequest userUpdateRequest) {
        User user = userRepository
                .findById(id)
                .orElseThrow(()->new UserNotFoundException("User Not Found"));

        user.setFullName(userUpdateRequest.getFullName() == null ? user.getFullName() : userUpdateRequest.getFullName());
        user.setUsername(userUpdateRequest.getUsername() == null ? user.getUsername() : userUpdateRequest.getUsername());
        user.setPhone(userUpdateRequest.getPhone() == null ? user.getPhone() : userUpdateRequest.getPhone());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return UserMapper.toUserResponse(user);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(()->new UserNotFoundException("User Not Found"));
        userRepository.delete(user);

    }
}
