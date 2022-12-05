package com.ldu.reservationOrder.entity;

import com.ldu.reservationOrder.dto.ResUserDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "RES_USER")
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="res_user_id")
    private Long resUserId;

    @OneToOne(mappedBy = "resUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Restaurant restaurant;

    private String pass;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole roles;

    private String birth;
    private int mileage;


    @OneToMany(mappedBy = "resUser", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public ResUser(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
