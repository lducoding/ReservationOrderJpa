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
    return new ResponseEntity<>("", httpHeaders, HttpStatus.OK);
  }
}
