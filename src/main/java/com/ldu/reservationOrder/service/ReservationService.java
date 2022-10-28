package com.ldu.reservationOrder.service;

import com.ldu.reservationOrder.dto.ReservationDto;
import com.ldu.reservationOrder.entity.Menu;
import com.ldu.reservationOrder.entity.ResUser;
import com.ldu.reservationOrder.entity.Reservation;
import com.ldu.reservationOrder.entity.Restaurant;
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
        ResUser resUser = resUserRepository.findById(reservationDto.getResUserId())
            .orElseGet(() -> ResUser.builder().resUserId(-1L).build());

        Restaurant restaurant = restaurantRepository.findById(reservationDto.getRestaurantId())
            .orElseGet(() -> Restaurant.builder().restaurantId(-1L).build());

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

            for (Long menuId: reservationDto.getMenuIdList()) {
                reservationMenuRepository.getReferenceById(savedReservation.getReservationId(), menuId);
            }

        }
        return reservationDto.getReservationId();
    }
}
