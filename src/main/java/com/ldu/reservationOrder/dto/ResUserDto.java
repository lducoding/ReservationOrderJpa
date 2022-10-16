package com.ldu.reservationOrder.dto;

import com.ldu.reservationOrder.entity.ResUser;
import com.ldu.reservationOrder.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ResUserDto {

    private Long resUserId;
    private String pass;
    private String name;
    private String email;
    private UserRole roles;
    private String birth;
    private int mileage;

    public ResUserDto(ResUser resUser) {
        this.resUserId = resUser.getResUserId();
        this.name = resUser.getName();
        this.email = resUser.getEmail();
        this.roles = resUser.getRoles();
        this.birth = resUser.getBirth();
        this.mileage = resUser.getMileage();
    }
}
