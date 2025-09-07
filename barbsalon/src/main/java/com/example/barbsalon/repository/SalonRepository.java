package com.example.barbsalon.repository;

import com.example.barbsalon.models.Salon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {

    Optional<Salon> findByOwner(Long id);

    @Query("SELECT s FROM Salon s WHERE (6371000 * acos( cos(radians(:latitude)) * cos(radians(s.latitude)) * cos(radians(s.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(s.latitude)))) <= :distance")
    Page<Salon> findSalonsWithinDistance(
            Double latitude,
            Double longitude,
            Double distance,
            PageRequest pageable);
}
