package com.ldu.reservationOrder.controller;

import com.ldu.reservationOrder.dto.ResUserDto;
import com.ldu.reservationOrder.entity.ResUser;
import com.ldu.reservationOrder.service.ResUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ResUserController {

    private final ResUserService resUserService;

    @GetMapping("/userInfo/{resUserId}")
    public ResponseEntity<ResUserDto> userInfo(@PathVariable Long resUserId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResUserDto userInfo = resUserService.userInfo(resUserId);
        ResponseEntity<ResUserDto> resUserDtoResponseEntity = new ResponseEntity<>(userInfo, httpHeaders, HttpStatus.OK);
        return resUserDtoResponseEntity;
    }

    @PostMapping("/user")
    public ResponseEntity<Long> registerUser(@RequestBody ResUserDto ResUserDto) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        Long registerUserId = resUserService.registerUser(ResUserDto);
        if(registerUserId == 0) {
            throw new Exception("중복된 회원이 존재합니다.");
        }
        return new ResponseEntity<Long>(registerUserId, httpHeaders, HttpStatus.OK);
    }
}
