package com.ldu.reservationOrder.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
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

    @Builder
    @QueryProjection
    public RestaurantDetailDto(Long restaurantId, List<MenuDto> menuList, String location, String restaurantName, String category, int standardTime, GoalDto goalDto) {
        this.restaurantId = restaurantId;
        this.menuList = menuList;
        this.location = location;
        this.restaurantName = restaurantName;
        this.category = category;
        this.standardTime = standardTime;
        this.goalDto = goalDto;
    }
}
