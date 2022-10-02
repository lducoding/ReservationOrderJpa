package com.ldu.reservationOrder.dto;

import com.ldu.reservationOrder.entity.ResUser;
import com.ldu.reservationOrder.entity.UserRole;
import lombok.Data;

@Data
public class ResUserDto {

    private Long resUserId;
    private String pass;
    private String name;
    private String email;
    private UserRole roles;
    private String birth;
    private int mileage;

    public ResUserDto(ResUser resUserDto) {
        this.resUserId = resUserDto.getResUserId();
        this.name = resUserDto.getName();
        this.email = resUserDto.getEmail();
        this.roles = resUserDto.getRoles();
        this.birth = resUserDto.getBirth();
        this.mileage = resUserDto.getMileage();
    }
}
