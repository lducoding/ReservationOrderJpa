package com.ldu.reservationOrder.service;

import com.ldu.reservationOrder.dto.RestaurantDto;
import com.ldu.reservationOrder.entity.Restaurant;
import com.ldu.reservationOrder.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

  private final RestaurantRepository restaurantRepository;

  public Page<RestaurantDto> getRestaurantLists(Pageable pageable) {

    PageRequest pageRequest = PageRequest.of(page, size);
    int start = (int) pageRequest.getOffset();
    int end = Math.min((start + pageRequest.getPageSize()), userList.size());
    Page<User> userPage = new PageImpl<>(userList.subList(start, end), pageRequest, userList.size());

    List<RestaurantDto> collect = restaurantRepository.findAllRestaurantPaging(pageable).stream()
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

    new PageImpl<>(collect.)

    return
  }
}
