package com.ldu.reservationOrder.dto;

import com.ldu.reservationOrder.entity.Restaurant;
import com.ldu.reservationOrder.entity.UserRole;

import javax.persistence.*;

public class ResUserDto {

    private Long resUserId;
    private String pass;
    private String name;
    private String email;
    private UserRole roles;
    private String birth;
    private int mileage;
}
