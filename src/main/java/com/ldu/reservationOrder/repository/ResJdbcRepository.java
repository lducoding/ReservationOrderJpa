package com.ldu.reservationOrder.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ResJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public void insertBsList(List<Dto> bsEntityList) {
        jdbcTemplate.batchUpdate(
            "insert into PghdCommonEntity (DATA_CRE_DTM, REG_DTM, DATA_UPDT_DTM, user_id, DTYPE) values(?, ?, ?, ?, ?);"
                + "insert into pghd_blood_sugar (BLSG_PITM_CD, BLSG_VAL, PGHD_ID) values(?, ?, LAST_INSERT_ID());",
            new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1, bsEntityList.get(i).getDatetimeRecord());
                    ps.setString(2, bsEntityList.get(i).getDatetimeRegister());
                    ps.setString(3, bsEntityList.get(i).getDatetimeUpdate());
                    ps.setLong(4, bsEntityList.get(i).getUser().getId());
                    ps.setString(5, "BS");
                    ps.setString(6, bsEntityList.get(i).getStageCode());
                    ps.setInt(7, bsEntityList.get(i).getValue());
                }

                @Override
                public int getBatchSize() {
                    return bsEntityList.size();
                }
            }
        );
//        jdbcTemplate.batchUpdate(
//            "insert into pghd_blood_sugar (BLSG_PITM_CD, BLSG_VAL, PGHD_ID) values(?, ?, LAST_INSERT_ID()) ",
//            new BatchPreparedStatementSetter() {
//                @Override
//                public void setValues(PreparedStatement ps, int i) throws SQLException {
//                    ps.setString(1, bsEntityList.get(i).getStageCode());
//                    ps.setInt(2, bsEntityList.get(i).getValue());
//                }
//
//                @Override
//                public int getBatchSize() {
//                    return bsEntityList.size();
//                }
//            }
//        );

    }

}
