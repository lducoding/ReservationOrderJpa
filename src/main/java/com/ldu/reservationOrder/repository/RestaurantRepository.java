package com.ldu.reservationOrder.repository;

import com.ldu.reservationOrder.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

//  @Query("select menus from Restaurant")
  Page<Restaurant> findAllBy(Pageable pageable);

}
