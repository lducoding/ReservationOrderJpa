package com.ldu.reservationOrder.entity;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservation_id")
    private Long reservationId;

    private Long resUserId;
    private Long restaurantId;
    private String reservationDate;
    private String reservationStatus;
}
