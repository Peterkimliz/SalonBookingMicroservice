package com.example.product.dtos;

import java.time.LocalDateTime;


public record ProductResponse(
        Long id,
        String name,
        String description,
        int price,
        int quantity,
        LocalDateTime createdAt,
        String imageUrl,
        Long salonId

) {
}

