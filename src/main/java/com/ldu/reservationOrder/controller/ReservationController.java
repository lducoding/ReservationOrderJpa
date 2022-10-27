package com.ldu.reservationOrder.controller;

import com.ldu.reservationOrder.dto.ReservationDto;
import com.ldu.reservationOrder.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/reservation")
    public ResponseEntity<Long> registerReservation(@RequestBody ReservationDto reservationDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        Long reservationId = reservationService.registerReservation(reservationDto);
        return new ResponseEntity<Long>(reservationId, httpHeaders, HttpStatus.OK);
    }

}
