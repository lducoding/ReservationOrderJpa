package com.ldu.reservationOrder.entity;

import javax.persistence.*;

@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="goal_id")
    private Long goalId;

    private Long restaurantId;
    private GoalType goalType;
    private int goalMoney;
    private int recentMoney;
    private String success;
    private String registerDate;
}
