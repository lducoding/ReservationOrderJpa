package com.ldu.reservationOrder.service;

import com.ldu.reservationOrder.dto.ConfirmReservationDto;
import com.ldu.reservationOrder.dto.MenuDto;
import com.ldu.reservationOrder.dto.ReservationDto;
import com.ldu.reservationOrder.dto.UserReservationDto;
import com.ldu.reservationOrder.entity.*;
import com.ldu.reservationOrder.repository.*;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ResUserRepository resUserRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReservationMenuRepository reservationMenuRepository;
    private final ReservationJdbcRepository reservationJdbcRepository;

    @Transactional
    public Long registerReservation(ReservationDto reservationDto) {
        ResUser resUser = resUserRepository.findById(reservationDto.getResUserId())
                .orElseGet(() -> ResUser.builder().resUserId(-1L).build());

//        Restaurant restaurant = restaurantRepository.findById(reservationDto.getRestaurantId())
//                .orElseGet(() -> Restaurant.builder().restaurantId(-1L).build());

        // 이것과 같이 프록시 객체로 저장해도 상관없을거 같다.
//        ResUser resUser = resUserRepository.getReferenceById(reservationDto.getResUserId());

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
            reservationJdbcRepository.insertReservationMenuList(reservationDto.getMenuIdList(), savedReservation.getReservationId());
            return savedReservation.getReservationId();
        }
    }

    @Transactional
    public List<UserReservationDto> getUserReservationList(Long id, String userRole) {
        List<UserReservationDto> userReservationList = reservationRepository.getUserReservationList(id, userRole);

        for (UserReservationDto userReservationDto : userReservationList) {
            List<MenuDto> userReservationMenuList = reservationRepository.getUserReservationMenuList(userReservationDto.getReservationId());
            userReservationDto.setMenuList(userReservationMenuList);
        }

        return userReservationList;
    }

    public ConfirmReservationDto registerReservationConfirm(Long reservationId) {
        return reservationRepository.registerReservationConfirm(reservationId);
    }

    public Long updateReservationStatus(Long reservationId, String status) {

        return null;
    }
}
