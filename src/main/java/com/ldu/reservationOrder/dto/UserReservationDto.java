package com.ldu.reservationOrder.dto;

import com.querydsl.core.annotations.QueryProjection;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class UserReservationDto {
    private Long reservationId;
    private Long resUserId;
    private Long restaurantId;
    private String reservationDate;
    private String reservationStatus;
    private List<MenuDto> menuList;

    @QueryProjection
    public UserReservationDto(Long reservationId, Long resUserId, Long restaurantId, String reservationDate, String reservationStatus) {
        this.reservationId = reservationId;
        this.resUserId = resUserId;
        this.restaurantId = restaurantId;
        this.reservationDate = reservationDate;
        this.reservationStatus = reservationStatus;
    }
}
