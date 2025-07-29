package com.salon.user.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserUpdateRequest {
    private String username;
    private String fullName;
    private String phone;


    public UserUpdateRequest() {
    }

    public UserUpdateRequest(String username, String fullName,
                             String phone
    ) {
        this.username = username;
        this.fullName = fullName;
        this.phone = phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
