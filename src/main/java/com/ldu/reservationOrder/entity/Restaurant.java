package com.ldu.reservationOrder.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "RESTAURANT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="restaurant_id")
    private Long restaurantId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "res_user_id")
    private ResUser resUser;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "goal_id")
    private Goal goal;

    private String location;
    private String restaurantName;
    private String category;
    private int standardTime;

    @OneToMany(mappedBy = "restaurantReservation", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "restaurantMenu", cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

    public void addResUser(ResUser resUser) {
        this.resUser = resUser;
        resUser.setRestaurant(this);
    }

    public void addGoal(Goal goal) {
        this.goal = goal;
        goal.setRestaurant(this);
    }

    @Builder
    public Restaurant(Long restaurantId, ResUser resUser, Goal goal, String location,
        String restaurantName, String category, int standardTime, List<Reservation> reservations,
        List<Menu> menus) {
        this.restaurantId = restaurantId;
        this.resUser = resUser;
        this.goal = goal;
        this.location = location;
        this.restaurantName = restaurantName;
        this.category = category;
        this.standardTime = standardTime;
        this.reservations = reservations;
        this.menus = menus;
    }
}
