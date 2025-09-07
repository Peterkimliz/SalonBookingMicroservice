package com.example.barbsalon.services.salon;

import com.example.barbsalon.dtos.ApiResponse;
import com.example.barbsalon.dtos.Pagination;
import com.example.barbsalon.dtos.salon.SalonRequest;
import com.example.barbsalon.dtos.salon.SalonResponse;
import com.example.barbsalon.exceptions.ItemExistsException;
import com.example.barbsalon.exceptions.ItemNotFound;
import com.example.barbsalon.mapper.salon.SalonMapper;
import com.example.barbsalon.models.Category;
import com.example.barbsalon.models.Salon;
import com.example.barbsalon.repository.CategoryRepository;
import com.example.barbsalon.repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonServiceImpl implements SalonService {

    @Autowired
    SalonRepository salonRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ApiResponse<SalonResponse> createSalon(SalonRequest salonRequest) {
        Optional<Salon> foundSalon = salonRepository.findByOwner(salonRequest.ownerId());
        if (foundSalon.isPresent()) {
            throw new ItemExistsException("You already have salon in our systems");
        }
        // todo user service
        Optional<Category> foundCategory = categoryRepository.findById(salonRequest.category());
        if (foundCategory.isEmpty()) {
            throw new ItemExistsException("Category with id not found");
        }

        Salon salon = SalonMapper.toSalon(salonRequest);

        salon.setOwner(salonRequest.ownerId());
        salon.setCategory(foundCategory.get());
        System.out.println(salon);
        salonRepository.save(salon);
        return new ApiResponse<>(SalonMapper.toSalonResponse(salon));
    }

    @Override
    public ApiResponse<SalonResponse> getSalonById(Long id) {
        Salon salon = salonRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFound("Salon with id not found"));
        return new ApiResponse<>(SalonMapper.toSalonResponse(salon));
    }

    @Override
    public ApiResponse<SalonResponse> updateSalonById(Long id, SalonRequest salonRequest) {
        return null;
    }

    @Override
    public ApiResponse<SalonResponse> getSalonByOwner(Long ownerId) {
        Salon salon = salonRepository
                .findByOwner(ownerId)
                .orElseThrow(() -> new ItemNotFound("Salon with ownerId  not found"));
        return new ApiResponse<>(SalonMapper.toSalonResponse(salon));
    }

    @Override
    public Pagination<SalonResponse> getSalons(
            Integer pageNumber, Integer pageCount, String search,
            Long categoryId, Double latitude, Double longitude) {
        PageRequest page = PageRequest.of(
                pageNumber, pageCount,
                Sort.by(Sort.Direction.DESC, "createdAt"));

        Page<Salon> all;

        if (latitude != null && longitude != null) {
            all = salonRepository.findSalonsWithinDistance(latitude, longitude, 100.0, page);
        } else {
            all = salonRepository.findAll(page);
        }


        List<Salon> salons = all.getContent();
        return new Pagination<>(
                        salons.stream().map(SalonMapper::toSalonResponse).toList(),
                        all.getTotalElements(),
                        all.getTotalPages(),
                        all.getPageable().getPageNumber(),
                        all.getPageable().getPageSize()
                );
    }







    @Override
    public void deleteSalon(Long id) {
        Salon salon = salonRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFound("Salon with id not found"));
        salonRepository.delete(salon);

    }

}
