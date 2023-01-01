package com.ldu.reservationOrder.repository;

import static com.ldu.reservationOrder.entity.QRestaurant.restaurant;
import static com.ldu.reservationOrder.entity.QMenu.menu;
import static com.ldu.reservationOrder.entity.QGoal.goal;
import static org.springframework.util.StringUtils.hasText;

import com.ldu.reservationOrder.dto.*;
import com.ldu.reservationOrder.dto.QConfirmReservationDto;
import com.ldu.reservationOrder.dto.QMenuDto;
import com.ldu.reservationOrder.dto.QUserReservationDto;
import com.ldu.reservationOrder.entity.QGoal;
import com.querydsl.core.types.Projections;
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

    @Override
    public RestaurantDetailDto getRestaurantDetail(Long id) {
        return queryFactory.select(new QRestaurantDetailDto(
                        restaurant.restaurantId,
                        null,
                        restaurant.location,
                        restaurant.restaurantName,
                        restaurant.category,
                        restaurant.standardTime,
                        null
                )).from(restaurant, menu, goal)
                .where(restaurant.restaurantId.eq(id)
                        .and(restaurant.restaurantId.eq(menu.restaurantMenu.restaurantId))
                        .and(menu.restaurantMenu.restaurantId.eq(goal.restaurant.restaurantId)))
                .fetchOne();
    }

    @Override
    public List<MenuDto> getRestaurantDetailMenuList(Long id) {
        return queryFactory.select(
                        new QMenuDto(
                                menu.menuId, menu.restaurantMenu.restaurantId, menu.menuName, menu.menuPrice, menu.menuImg
                        )
                ).from(restaurant, menu, goal)
                .where(restaurant.restaurantId.eq(id)
                        .and(restaurant.restaurantId.eq(menu.restaurantMenu.restaurantId))
                        .and(menu.restaurantMenu.restaurantId.eq(goal.restaurant.restaurantId)))
                .fetch();
    }

    @Override
    public GoalDto getRestaurantDetailGoal(Long id) {
                return queryFactory.select(
                                new QGoalDto(
                                        goal.goalId,
                                        goal.restaurant.restaurantId,
                                        goal.goalType.stringValue(),
                                        goal.goalMoney,
                                        goal.recentMoney,
                                        goal.success,
                                        goal.registerDate
                                )
                        ).from(restaurant, menu, goal)
                        .where(restaurant.restaurantId.eq(id)
                                .and(restaurant.restaurantId.eq(menu.restaurantMenu.restaurantId))
                                .and(menu.restaurantMenu.restaurantId.eq(goal.restaurant.restaurantId)))
                        .fetchOne();
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
