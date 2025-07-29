package com.salon.user.dto;

import com.salon.user.models.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {
    @NotBlank(message = "username is required")
    private String username;
    @NotBlank(message = "fullName is required")
    private String fullName;
    @NotBlank(message = "email is required")
    @Email(message = "enter a valid email ")
    private String email;
    @NotBlank(message = "phone is required")
    private String phone;
    @NotBlank(message = "password is required")
    private String password;
    @NotBlank(message = "role is required")
    private String role=Role.CUSTOMER.name();

    public UserRequest() {
    }

    public UserRequest(String username, String fullName,
                       String email, String phone,
                       String password, String role
    ) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String  role) {
        this.role = role;
    }
}
