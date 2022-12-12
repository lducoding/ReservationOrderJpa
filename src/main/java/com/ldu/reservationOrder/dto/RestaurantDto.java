package com.ldu.reservationOrder.dto;

import lombok.Builder;
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

    @Builder
    public RestaurantDto(Long restaurantId, Long resUserId, Long goalId, String location, String restaurantName, String category, int standardTime) {
        this.restaurantId = restaurantId;
        this.resUserId = resUserId;
        this.goalId = goalId;
        this.location = location;
        this.restaurantName = restaurantName;
        this.category = category;
        this.standardTime = standardTime;
    }
}
