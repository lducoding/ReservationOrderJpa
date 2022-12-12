package com.ldu.reservationOrder.service;

import com.ldu.reservationOrder.dto.RestaurantDto;
import com.ldu.reservationOrder.entity.Restaurant;
import com.ldu.reservationOrder.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<RestaurantDto> getRestaurantLists() {
        return restaurantRepository.findAll().stream().map(
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
    }
}
