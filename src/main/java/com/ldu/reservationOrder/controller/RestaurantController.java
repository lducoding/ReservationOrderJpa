package com.ldu.reservationOrder.controller;

import com.ldu.reservationOrder.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

  private final RestaurantService restaurantService;

  @GetMapping("/restaurants")
  public ResponseEntity<?> getRestaurantLists() {
    HttpHeaders httpHeaders = new HttpHeaders();
    restaurantService.
    return new ResponseEntity<>("", httpHeaders, HttpStatus.OK);
  }
}
