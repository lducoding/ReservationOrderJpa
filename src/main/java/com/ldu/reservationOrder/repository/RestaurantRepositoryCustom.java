package com.ldu.reservationOrder.repository;

import com.ldu.reservationOrder.dto.RestaurantDetailDto;
import com.ldu.reservationOrder.dto.RestaurantDto;
import com.ldu.reservationOrder.dto.RestaurantSerchDto;
import com.ldu.reservationOrder.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepositoryCustom {

    List<RestaurantDto> getSearchRestaurantLists(RestaurantSerchDto restaurantSerchDto);

    RestaurantDetailDto getRestaurantDetail(Long id);
}
