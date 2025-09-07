package com.example.barbsalon.services.salon;


import com.example.barbsalon.dtos.ApiResponse;
import com.example.barbsalon.dtos.Pagination;
import com.example.barbsalon.dtos.salon.SalonRequest;
import com.example.barbsalon.dtos.salon.SalonResponse;

public interface SalonService {
    ApiResponse<SalonResponse> createSalon(SalonRequest salonRequest);
    ApiResponse<SalonResponse> getSalonById(Long id);
    ApiResponse<SalonResponse> updateSalonById(Long id,SalonRequest salonRequest);
    ApiResponse<SalonResponse> getSalonByOwner(Long ownerId);
    Pagination<SalonResponse> getSalons(Integer pageNumber, Integer pageCount,
                                        String search, Long categoryId,
                                        Double latitude, Double longitude);

    void deleteSalon(Long id);
}
