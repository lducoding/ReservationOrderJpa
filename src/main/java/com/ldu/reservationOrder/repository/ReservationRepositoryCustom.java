package com.ldu.reservationOrder.repository;


import com.ldu.reservationOrder.dto.ConfirmReservationDto;
import com.ldu.reservationOrder.dto.MenuDto;
import com.ldu.reservationOrder.dto.UserReservationDto;
import java.util.List;

public interface ReservationRepositoryCustom {

    List<UserReservationDto> getUserReservationList(Long id, String userRole);

    List<MenuDto> getUserReservationMenuList(Long id);

    ConfirmReservationDto registerReservationConfirm(Long id);
}
