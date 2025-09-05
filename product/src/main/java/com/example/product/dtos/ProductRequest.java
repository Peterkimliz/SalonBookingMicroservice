package com.example.product.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record ProductRequest(
        @NotBlank(message = "name is required")
        String name,
        @NotBlank(message = "description is required")
        String description,
        @NotBlank(message = "price is required")
        int price,
        @NotNull(message = "quantity is required")
        int quantity,
        @NotNull(message = "image is required")
        MultipartFile image,
        @NotNull(message = "salonId is required")
        Long salonId
){ }