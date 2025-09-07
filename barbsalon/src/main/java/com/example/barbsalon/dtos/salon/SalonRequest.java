package com.example.barbsalon.dtos.salon;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public record SalonRequest(
        @NotBlank(message = "name is required")
        String name,
        @NotBlank(message = "address is required")
        String address,
        @NotNull(message = "category is required")
        Long category,
        @NotNull(message = "Latitude is required")
        @DecimalMin(value = "-90.0", inclusive = true, message = "Latitude must be >= -90")
        @DecimalMax(value = "90.0", inclusive = true, message = "Latitude must be <= 90")
        double latitude,
        @NotNull(message = "Longitude is required")
        @DecimalMin(value = "-180.0", inclusive = true, message = "Longitude must be >= -180")
        @DecimalMax(value = "180.0", inclusive = true, message = "Longitude must be <= 180")
        double longitude,

        @NotEmpty(message = "At least one image is required")
        List<MultipartFile> images,
        @NotBlank(message = "about is required")
        String about,
        String email,
        @NotBlank(message = "city is required ")
        String city,
        @NotBlank(message = "phone is required ")
        String phone,
        @NotNull(message = "ownerId is required")
        Long ownerId

) {
}
