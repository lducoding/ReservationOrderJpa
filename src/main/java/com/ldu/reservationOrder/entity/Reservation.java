package com.ldu.reservationOrder.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "RESERVATION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservation_id")
    private Long reservationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "res_user_id")
    private ResUser resUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurantReservation;

    private String reservationDate;
    private String reservationStatus;

    @Builder
    public Reservation(Long reservationId, ResUser resUser, Restaurant restaurantReservation,
        String reservationDate, String reservationStatus) {
        this.reservationId = reservationId;
        this.resUser = resUser;
        this.restaurantReservation = restaurantReservation;
        this.reservationDate = reservationDate;
        this.reservationStatus = reservationStatus;
    }
}
