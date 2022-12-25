package com.ldu.reservationOrder.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class RestaurantDetailDto {

    private Long restaurantId;
    private List<MenuDto> menuList;
    private String location;
    private String restaurantName;
    private String category;
    private int standardTime;
    private GoalDto goalDto;

}
