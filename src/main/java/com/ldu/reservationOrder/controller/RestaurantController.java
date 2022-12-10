package com.ldu.reservationOrder.controller;

import com.ldu.reservationOrder.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

  @GetMapping("/restaurants")
  public ResponseEntity<?> getRestaurantLists() {
    HttpHeaders httpHeaders = new HttpHeaders();
    // elk 설치해서 한글 자모 분리해서 검색하는 거 완료함!!!! 개쩐다 시바 ㅋㅋㅋㅋㅋㅋ
    return new ResponseEntity<>("", httpHeaders, HttpStatus.OK);
  }
}
