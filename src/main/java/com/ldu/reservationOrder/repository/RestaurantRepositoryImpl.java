package com.ldu.reservationOrder.repository;

import static com.ldu.reservationOrder.entity.QMenu.menu;
import static com.ldu.reservationOrder.entity.QReservation.reservation;
import static com.ldu.reservationOrder.entity.QReservationMenu.reservationMenu;

import com.ldu.reservationOrder.dto.ConfirmReservationDto;
import com.ldu.reservationOrder.dto.MenuDto;
import com.ldu.reservationOrder.dto.QConfirmReservationDto;
import com.ldu.reservationOrder.dto.QMenuDto;
import com.ldu.reservationOrder.dto.QUserReservationDto;
import com.ldu.reservationOrder.dto.UserReservationDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {

    private final JPAQueryFactory queryFactory;


}
