package com.ldu.reservationOrder.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class ReservationDto {
    private Long resUserId;
    private Long restaurantId;
    private String reservationDate;
    private String reservationStatus;
    private List<Long> menuIdList;
}
