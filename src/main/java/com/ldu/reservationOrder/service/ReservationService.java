package com.ldu.reservationOrder.service;

import com.ldu.reservationOrder.dto.ReservationDto;
import com.ldu.reservationOrder.entity.*;
import com.ldu.reservationOrder.repository.*;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ResUserRepository resUserRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReservationMenuRepository reservationMenuRepository;


    public Long registerReservation(ReservationDto reservationDto) {
        ResUser resUser = resUserRepository.getReferenceById(reservationDto.getResUserId());

        Restaurant restaurant = restaurantRepository.getReferenceById(reservationDto.getRestaurantId());

        if (resUser.getResUserId() == -1L || restaurant.getRestaurantId() == -1L) {
            return -1L;
        } else {
            Reservation savedReservation = reservationRepository.save(
                Reservation.builder()
                    .resUser(resUser)
                    .restaurantReservation(restaurant)
                    .reservationDate(reservationDto.getReservationDate())
                    .reservationStatus(reservationDto.getReservationStatus())
                    .build()
            );

            // 벌크로 reservation_menu에 값 넣기

        }
        return reservationDto.getReservationId();
    }
}
