package com.ldu.reservationOrder.repository;

import com.ldu.reservationOrder.entity.ReservationMenu;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.ldu.reservationOrder.dto.ResUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReservationJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public void insertReservationMenuList(List<Long> menuIdList, Long reservationId) {
        jdbcTemplate.batchUpdate(
            "insert into RESERVATION_MENU (reservation_id, menu_id) values(?, ?);",
            new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setLong(1, reservationId);
                    ps.setLong(2, menuIdList.get(i));
                }

                @Override
                public int getBatchSize() {
                    return menuIdList.size();
                }
            }
        );

    }

}
