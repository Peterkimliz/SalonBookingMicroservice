package com.example.barbsalon.dtos.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record CategoryRequest(
        @NotNull(message = "image is required")
        MultipartFile image,
        @NotBlank(message = "name is required")
        String name
) {
}
