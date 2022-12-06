package com.ldu.reservationOrder.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "RESERVATION_MENU")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservation_menu_id")
    private Long reservationMenuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Builder
    public ReservationMenu(Long reservationMenuId, Reservation reservation, Menu menu) {
        this.reservationMenuId = reservationMenuId;
        this.reservation = reservation;
        this.menu = menu;
    }
}
