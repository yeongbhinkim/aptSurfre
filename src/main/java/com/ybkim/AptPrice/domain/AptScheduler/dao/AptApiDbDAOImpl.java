package com.ybkim.AptPrice.domain.AptScheduler.dao;


import com.ybkim.AptPrice.domain.AptScheduler.AptApiDb;
import com.ybkim.AptPrice.domain.AptScheduler.CountyCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor

public class AptApiDbDAOImpl implements AptApiDbDAO {

  private final JdbcTemplate jdbcTemplate;

  /**
   * API -> DB insert
   *
   * @return
   */
  @Override
  public void insertApiDb(List<AptApiDb>  aptApiDb) {
    StringBuffer sql = new StringBuffer();

    sql.append(" INSERT INTO apt ( ");
    sql.append("     apt_id, city, street, bon_bun, bu_bun, dan_gi_myeong,  ");
    sql.append("     square_meter, contract_date, contract_day, amount, ");
    sql.append("     layer, construction_date, road_name, reason_cancellation_date, ");
    sql.append("     transaction_type, location_agency ");
    sql.append(" ) VALUES ( ");
    sql.append("     NEXT VALUE FOR apt_id_seq, ?, ?, ?, ?, ?, ");
    sql.append("     ?, ?, ?, ?, ");
    sql.append("     ?, ?, ?, ?, ");
    sql.append("     ?, ? ");
    sql.append(" ) ");

    //배치 처리 : 여러건의 갱신작업을 한꺼번에 처리하므로 단건처리할때보다 성능이 좋다.
    jdbcTemplate.batchUpdate(sql.toString(), new BatchPreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setString(1, aptApiDb.get(i).getCity());
        ps.setString(2, aptApiDb.get(i).getStreet());
        ps.setString(3, aptApiDb.get(i).getBon_bun());
        ps.setString(4, aptApiDb.get(i).getBu_bun());
        ps.setString(5, aptApiDb.get(i).getDan_gi_myeong());
        ps.setString(6, aptApiDb.get(i).getSquare_meter());
        ps.setString(7, aptApiDb.get(i).getContract_date());
        ps.setString(8, aptApiDb.get(i).getContract_day());
        ps.setString(9, aptApiDb.get(i).getAmount());
        ps.setString(10, aptApiDb.get(i).getLayer());
        ps.setString(11, aptApiDb.get(i).getConstruction_date());
        ps.setString(12, aptApiDb.get(i).getRoad_name());
        ps.setString(13, aptApiDb.get(i).getReason_cancellation_date());
        ps.setString(14, aptApiDb.get(i).getTransaction_type());
        ps.setString(15, aptApiDb.get(i).getLocation_agency());
      }

      //배치처리할 건수
      @Override
      public int getBatchSize() {
        return aptApiDb.size();
      }

    });

  }

  /**
   * 시군구 조회
   *
   * @return
   */
  @Override
  public List<CountyCode> apiSelectRegionCounty() {
    StringBuffer sql = new StringBuffer();

    sql.append(" SELECT COUNTY_CODE FROM REGION_COUNTY ");

    List<CountyCode> list = jdbcTemplate.query(sql.toString(),
            new BeanPropertyRowMapper<>(CountyCode.class)
    );
    return list;
  }

}