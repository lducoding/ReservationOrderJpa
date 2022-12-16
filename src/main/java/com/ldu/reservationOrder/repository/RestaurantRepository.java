package com.ldu.reservationOrder.repository;

import com.ldu.reservationOrder.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

  Page<Restaurant> findAllRestaurantPaging(Pageable pageable);

}
