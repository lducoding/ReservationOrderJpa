package com.ldu.reservationOrder.entity;

import javax.persistence.*;

@Entity(name = "RES_USER")
public class ResUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="res_user_id")
    private Long resUserId;

    private String pass;
    private String name;
    private String email;
    private UserRole roles;
    private String birth;
    private int mileage;
}
