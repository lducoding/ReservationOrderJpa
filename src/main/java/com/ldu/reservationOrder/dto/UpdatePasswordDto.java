package com.ldu.reservationOrder.dto;

import lombok.Data;

@Data
public class UpdatePasswordDto {
    private Long resUserId;
    private String pass;
}
