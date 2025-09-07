package com.example.barbsalon.dtos.salon;

import java.time.LocalDateTime;
import java.util.List;

public record SalonResponse (
     Long id,
     String name,
     String address,
     Long category,
     List<String> images,
     String about,
     String email,
     String city,
     String phone,
     Long owner,
     Double totalRating,
     Integer ratingCount,
     LocalDateTime createdAt,
     LocalDateTime updatedAt

){}

