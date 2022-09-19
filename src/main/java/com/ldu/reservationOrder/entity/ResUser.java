package com.ldu.reservationOrder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "RES_USER")
public class ResUser {

    @Id
    @GeneratedValue
    @Column(name="res_user_id")
    private Long resUserId;
}
