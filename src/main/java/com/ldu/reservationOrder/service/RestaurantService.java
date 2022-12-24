package com.ldu.reservationOrder.service;

import com.ldu.reservationOrder.dto.RestaurantDto;
import com.ldu.reservationOrder.dto.RestaurantSerchDto;
import com.ldu.reservationOrder.entity.Restaurant;
import com.ldu.reservationOrder.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

  private final RestaurantRepository restaurantRepository;

  public Page<RestaurantDto> getRestaurantLists(Pageable pageable) {
    List<RestaurantDto> collect = restaurantRepository.findAllBy(pageable).stream()
        .map(
            res -> {
              return RestaurantDto.builder()
                  .restaurantId(res.getRestaurantId())
                  .resUserId(res.getResUser().getResUserId())
                  .goalId(res.getGoal().getGoalId())
                  .location(res.getLocation())
                  .restaurantName(res.getRestaurantName())
                  .category(res.getCategory())
                  .standardTime(res.getStandardTime())
                  .build();
            }
        ).collect(Collectors.toList());

      PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
      Page<RestaurantDto> restaurantDtoPage = new PageImpl<>(collect, pageRequest, collect.size());

    return restaurantDtoPage;
  }

  public List<RestaurantDto> getSearchRestaurantLists(RestaurantSerchDto restaurantSerchDto) {
      return restaurantRepository.getSearchRestaurantLists(restaurantSerchDto);
  }
}
