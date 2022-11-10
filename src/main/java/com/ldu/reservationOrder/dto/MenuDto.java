package com.ldu.reservationOrder.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class MenuDto {
    private Long menuId;
    private Long restaurantId;
    private String menuName;
    private int menuPrice;
    private String menuImg;

    @QueryProjection
    public MenuDto(Long menuId, Long restaurantId, String menuName, int menuPrice, String menuImg) {
        this.menuId = menuId;
        this.restaurantId = restaurantId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuImg = menuImg;
    }
}