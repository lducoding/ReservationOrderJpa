package com.ldu.reservationOrder.repository;

import static com.ldu.reservationOrder.entity.QMenu.menu;
import static com.ldu.reservationOrder.entity.QResUser.resUser;
import static com.ldu.reservationOrder.entity.QReservation.reservation;
import static com.ldu.reservationOrder.entity.QReservationMenu.reservationMenu;

import com.ldu.reservationOrder.dto.MenuDto;
import com.ldu.reservationOrder.dto.QMenuDto;
import com.ldu.reservationOrder.dto.QUserReservationDto;
import com.ldu.reservationOrder.dto.UserReservationDto;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<UserReservationDto> getUserReservationList(Long id, String userRole) {

//        List<MenuDto> menuDtoList = queryFactory.select(
//                new QMenuDto(
//                    menu.menuId,
//                    menu.restaurantMenu.restaurantId,
//                    menu.menuName,
//                    menu.menuPrice,
//                    menu.menuImg)
//            )
//            .from(menu, reservationMenu)
//            .where(menu.menuId.eq(reservationMenu.menu.menuId)).fetch();

        List<UserReservationDto> userReservationDtoList = queryFactory.select(
                new QUserReservationDto(
                    reservation.reservationId,
                    reservation.resUser.resUserId,
                    reservation.restaurantReservation.restaurantId,
                    reservation.reservationDate,
                    reservation.reservationStatus
                ))
            .from(reservation)
            .where(
                    new CaseBuilder().when(userRole.equals("ROLE_CUSTOMER")).then(reservation.resUser.resUserId.eq(id))
                            .otherwise()
            )
            .fetch();

        return userReservationDtoList;

    }

    @Override
    public List<MenuDto> getUserReservationMenuList(Long id) {
        List<MenuDto> menuDtoList = queryFactory.select(
                new QMenuDto(
                    menu.menuId,
                    menu.restaurantMenu.restaurantId,
                    menu.menuName,
                    menu.menuPrice,
                    menu.menuImg
                ))
            .from(menu, reservationMenu)
            .where(
                reservationMenu.reservation.reservationId.eq(id)
                    .and(reservationMenu.menu.menuId.eq(menu.menuId))
            ).fetch();
        return menuDtoList;
    }

}
