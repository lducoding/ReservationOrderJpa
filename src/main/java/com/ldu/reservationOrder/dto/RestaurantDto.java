package com.ldu.reservationOrder.dto;

import lombok.Data;

@Data
public class RestaurantDto {

    private Long restaurantId;
    private Long resUserId;
    private Long goalId;
    private String location;
    private String restaurantName;
    private String category;
    private int standardTime;
}
