package com.ldu.reservationOrder.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RestaurantSerchDto {

    private String location;
    private String restaurantName;
    private String category;
}
