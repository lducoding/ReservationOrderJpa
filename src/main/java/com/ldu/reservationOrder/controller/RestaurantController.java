package com.ldu.reservationOrder.controller;

import com.ldu.reservationOrder.dto.RestaurantDto;
import com.ldu.reservationOrder.dto.RestaurantSerchDto;
import com.ldu.reservationOrder.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public ResponseEntity<Page<RestaurantDto>> getRestaurantLists(Pageable pageable) {
        HttpHeaders httpHeaders = new HttpHeaders();
        Page<RestaurantDto> restaurantLists = restaurantService.getRestaurantLists(pageable);
        return new ResponseEntity<Page<RestaurantDto>>(restaurantLists, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/searchRestaurants")
    public ResponseEntity<?> getSearchRestaurantLists(@RequestParam(defaultValue = "1") Integer pageNum,
                                                     @RequestParam(defaultValue = "8") Integer pageSize,
                                                     RestaurantSerchDto restaurantSerchDto) {
      // dto의 값이 있는 걸로만 검색
        return new ResponseEntity<>(restaurantDtoPageInfo, HttpStatus.OK);
    }
}
