package com.ldu.reservationOrder.repository;

import static com.ldu.reservationOrder.entity.QResUser.resUser;

import com.querydsl.jpa.impl.JPAQueryFactory;

public class ResRepositoryImpl implements ResRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ResRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    @Override
    public void updateBsData(dto dto) {
        queryFactory.update(resUser)
            .set(resUser, updateBsDto.getValue())
            .where(resUser.email.eq(dto.getId()))
            .execute();
    }
}
