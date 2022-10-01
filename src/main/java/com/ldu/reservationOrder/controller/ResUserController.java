package com.ldu.reservationOrder.controller;

import com.ldu.reservationOrder.dto.ResUserDto;
import com.ldu.reservationOrder.entity.ResUser;
import com.ldu.reservationOrder.service.ResUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ResUserController {

    private final ResUserService resUserService;

    @GetMapping("/userInfo/{userId}")
    public ResponseEntity<ResUserDto> userInfo(@PathVariable Long resUserId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResUserDto userInfo = resUserService.userInfo(resUserId);
        return new ResponseEntity<ResUserDto>(userInfo, httpHeaders, HttpStatus.OK);
    }
}
