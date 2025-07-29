package com.salon.booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking/")
public class BookingController {

    @GetMapping("")
    public ResponseEntity<String>getAllBookings(){
        return  new ResponseEntity<>("Booking Api", HttpStatus.OK);
    }
}
