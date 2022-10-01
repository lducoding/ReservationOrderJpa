package com.ldu.reservationOrder.repository;

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
public class ResJdbcRepository {

//    private final JdbcTemplate jdbcTemplate;
//
//    public void insertBsList(List<ResUserDto> resUserDtoList) {
//        jdbcTemplate.batchUpdate(
//            "insert into PghdCommonEntity (DATA_CRE_DTM, REG_DTM, DATA_UPDT_DTM, user_id, DTYPE) values(?, ?, ?, ?, ?);"
//                + "insert into pghd_blood_sugar (BLSG_PITM_CD, BLSG_VAL, PGHD_ID) values(?, ?, LAST_INSERT_ID());",
//            new BatchPreparedStatementSetter() {
//                @Override
//                public void setValues(PreparedStatement ps, int i) throws SQLException {
//                    ps.setString(1, resUserDtoList.get(i).getDatetimeRecord());
//                    ps.setString(2, resUserDtoList.get(i).getDatetimeRegister());
//                    ps.setString(3, resUserDtoList.get(i).getDatetimeUpdate());
//                    ps.setLong(4, resUserDtoList.get(i).getUser().getId());
//                    ps.setString(5, "BS");
//                    ps.setString(6, resUserDtoList.get(i).getStageCode());
//                    ps.setInt(7, resUserDtoList.get(i).getValue());
//                }
//
//                @Override
//                public int getBatchSize() {
//                    return resUserDtoList.size();
//                }
//            }
//        );


//        jdbcTemplate.batchUpdate(
//            "insert into pghd_blood_sugar (BLSG_PITM_CD, BLSG_VAL, PGHD_ID) values(?, ?, LAST_INSERT_ID()) ",
//            new BatchPreparedStatementSetter() {
//                @Override
//                public void setValues(PreparedStatement ps, int i) throws SQLException {
//                    ps.setString(1, resUserDtoList.get(i).getStageCode());
//                    ps.setInt(2, resUserDtoList.get(i).getValue());
//                }
//
//                @Override
//                public int getBatchSize() {
//                    return resUserDtoList.size();
//                }
//            }
//        );

//    }

}
