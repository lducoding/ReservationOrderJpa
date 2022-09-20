package com.ldu.reservationOrder.entity;

import javax.persistence.*;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="menu_id")
    private Long menuId;

    private Long restaurantId;
    private String menuName;
    private int menuPrice;
    private String menuImg;
}
