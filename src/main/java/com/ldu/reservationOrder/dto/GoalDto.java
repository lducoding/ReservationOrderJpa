package com.ldu.reservationOrder.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class GoalDto {

    private Long goalId;
    private Long restaurantId;
    private String goalType;
    private int goalMoney;
    private int recentMoney;
    private String success;
    private String registerDate;

    @QueryProjection
    public GoalDto(Long goalId, Long restaurantId, String goalType, int goalMoney, int recentMoney, String success, String registerDate) {
        this.goalId = goalId;
        this.restaurantId = restaurantId;
        this.goalType = goalType;
        this.goalMoney = goalMoney;
        this.recentMoney = recentMoney;
        this.success = success;
        this.registerDate = registerDate;
    }
}
