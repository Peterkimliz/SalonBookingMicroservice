package com.example.product.client;

import com.example.product.dtos.ApiResponse;
import com.example.product.dtos.SalonReponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "salonClient",url = "${server.salonUrl}")
public interface SalonClient {

    @GetMapping("api/v1/salon/{id}")
     ApiResponse<SalonReponse> getSalon(@PathVariable("id") Long id);
}
