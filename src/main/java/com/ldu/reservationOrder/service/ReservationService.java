package com.ldu.reservationOrder.service;

import com.ldu.reservationOrder.dto.ReservationDto;
import com.ldu.reservationOrder.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;


    public Long registerReservation(ReservationDto reservationDto) {

        return reservationDto.getReservationId();
    }
}
