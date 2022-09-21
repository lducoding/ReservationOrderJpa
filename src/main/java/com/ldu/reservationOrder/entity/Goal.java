package com.ldu.reservationOrder.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "GOAL")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="goal_id")
    private Long goalId;

    @OneToOne(mappedBy = "goal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    private GoalType goalType;

    private int goalMoney;
    private int recentMoney;
    private String success;
    private String registerDate;

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
