package com.example.barbsalon.controllers;


import com.example.barbsalon.dtos.ApiResponse;
import com.example.barbsalon.dtos.Pagination;
import com.example.barbsalon.dtos.salon.SalonRequest;
import com.example.barbsalon.dtos.salon.SalonResponse;
import com.example.barbsalon.services.salon.SalonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Salon")
@RestController
@RequestMapping("${server.appVersion}/salon/")
public class SalonController {

    @Autowired
    private SalonService salonService;

    @PostMapping(value = "create",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<SalonResponse>> createSalon(@Valid @ModelAttribute SalonRequest salonRequest) {
        return new ResponseEntity<>(salonService.createSalon(salonRequest), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<SalonResponse>> getSalonById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(salonService.getSalonById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<SalonResponse>> updateSalonById(@PathVariable("id") Long id, @RequestBody SalonRequest salonRequest) {
        return new ResponseEntity<>(salonService.updateSalonById(id, salonRequest), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Pagination<SalonResponse>> getSalons(
            @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
            @RequestParam(value = "search", defaultValue = "") String search,
            @RequestParam(value = "category", required = false) Long category,
            @RequestParam(value = "latitude", required = false) Double latitude,
            @RequestParam(value = "longitude", required = false) Double longitude
    ) {
        return new ResponseEntity<>(salonService.getSalons(
                pageNumber, pageSize,
                search, category,
                latitude, longitude), HttpStatus.OK);
    }

    @GetMapping("owner/{id}")
    public ResponseEntity<ApiResponse<SalonResponse>> getSalonByOwnerId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(salonService.getSalonByOwner(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<?>> deleteSalon(@PathVariable("id") Long id) {
        salonService.deleteSalon(id);
        return new ResponseEntity<>(new ApiResponse<String>(
                "Salon Deleted"
        ), HttpStatus.OK);
    }
}
