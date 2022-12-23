package com.ldu.reservationOrder.repository;

import static com.ldu.reservationOrder.entity.QRestaurant.restaurant;
import static org.springframework.util.StringUtils.hasText;

import com.ldu.reservationOrder.dto.*;
import com.ldu.reservationOrder.dto.QConfirmReservationDto;
import com.ldu.reservationOrder.dto.QMenuDto;
import com.ldu.reservationOrder.dto.QUserReservationDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {

    private final JPAQueryFactory queryFactory;


    @Override
    public List<RestaurantDto> getSearchRestaurantLists(RestaurantSerchDto restaurantSerchDto) {
        List<RestaurantDto> restaurantDtoList = queryFactory.select(
                        new QRestaurantDto(
                                restaurant.restaurantId,
                                restaurant.resUser.resUserId,
                                restaurant.goal.goalId,
                                restaurant.location,
                                restaurant.restaurantName,
                                restaurant.category,
                                restaurant.standardTime
                        ))
                .from(restaurant)
                .where(
                        locationLike(restaurantSerchDto.getLocation()),
                        restaurantNameLike(restaurantSerchDto.getRestaurantName()),
                        categoryLike(restaurantSerchDto.getCategory())
                )
                .fetch();
        return restaurantDtoList;
    }

    private BooleanExpression locationLike(String location) {
        return hasText(location) ? restaurant.location.like("%" + location + "%") : null;
    }

    private BooleanExpression restaurantNameLike(String restaurantName) {
        // contains는 앞뒤로 자동으로 % 붙여준다.
        return hasText(restaurantName) ? restaurant.restaurantName.contains(restaurantName) : null;
    }

    private BooleanExpression categoryLike(String category) {
        return hasText(category) ? restaurant.category.contains(category) : null;
    }
}
