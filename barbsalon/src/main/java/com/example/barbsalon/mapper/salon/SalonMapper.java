package com.example.barbsalon.mapper.salon;


import com.example.barbsalon.dtos.salon.SalonRequest;
import com.example.barbsalon.dtos.salon.SalonResponse;
import com.example.barbsalon.models.Salon;

import java.time.LocalDateTime;

public class SalonMapper {
    public static Salon toSalon(SalonRequest salonRequest) {
        Salon salon = new Salon();
        salon.setAbout(salonRequest.about());
        salon.setAddress(salonRequest.address());
        salon.setCity(salonRequest.city());
        salon.setEmail(salonRequest.email());
        salon.setName(salonRequest.name());
        salon.setPhone(salonRequest.phone());
        salon.setCreatedAt(LocalDateTime.now());
        salon.setTotalRating(0.0);
        salon.setRatingCount(0);
        salon.setLatitude(salonRequest.latitude());
        salon.setLongitude(salonRequest.longitude());
        return salon;
    }

    public static SalonResponse toSalonResponse(Salon salon) {
        return new SalonResponse(
                salon.getId(),
                salon.getName(),
                salon.getAddress(),
                salon.getCategory().getId(),
                salon.getImages(),
                salon.getAbout(),
                salon.getEmail(),
                salon.getCity(),
                salon.getPhone(),
                salon.getOwner(),

                salon.getTotalRating(),
                salon.getRatingCount(),
                salon.getCreatedAt(),
                salon.getUpdatedAt()

        );
    }


}
