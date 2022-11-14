package com.ldu.reservationOrder.dto;

import com.querydsl.core.annotations.QueryProjection;
import java.util.List;
import lombok.Data;

@Data
public class ConfirmReservationDto {
    private Long resUserId;
    private Long restaurantId;
    private String reservationDate;
    private String reservationStatus;
    private List<MenuDto> menuList;

    @QueryProjection
    public ConfirmReservationDto(Long resUserId, Long restaurantId, String reservationDate, String reservationStatus) {
        this.resUserId = resUserId;
        this.restaurantId = restaurantId;
        this.reservationDate = reservationDate;
        this.reservationStatus = reservationStatus;
    }
}
