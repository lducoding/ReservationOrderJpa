package com.ldu.reservationOrder.entity;

import com.ldu.reservationOrder.dto.ResUserDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "RES_USER")
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

    public ResUser(ResUserDto resUserDto) {
        this.pass = resUserDto.getPass();
        this.name = resUserDto.getName();
        this.email = resUserDto.getEmail();
        this.roles = resUserDto.getRoles();
        this.birth = resUserDto.getBirth();
        this.mileage = resUserDto.getMileage();
    }
}
