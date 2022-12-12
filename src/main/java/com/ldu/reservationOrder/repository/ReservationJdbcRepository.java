package com.ldu.reservationOrder.repository;

import com.ldu.reservationOrder.entity.ReservationMenu;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
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
            menuIdList, 500, (ps, menuId) -> {
              ps.setLong(1, reservationId);
              ps.setLong(2, menuId);
            }
        );
    }

}
