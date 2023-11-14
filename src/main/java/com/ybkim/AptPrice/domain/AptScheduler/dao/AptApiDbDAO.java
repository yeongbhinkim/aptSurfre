package com.ybkim.AptPrice.domain.AptScheduler.dao;


import com.ybkim.AptPrice.domain.AptScheduler.AptApiDb;
import com.ybkim.AptPrice.domain.AptScheduler.CountyCode;

import java.util.List;

public interface AptApiDbDAO {


  /**
   * API -> DB insert
   *
   * @return
   */
  void insertApiDb(List<AptApiDb> aptApiDb);

  /**
   * 시군구 조회
   * @return
   */
  List<CountyCode> apiSelectRegionCounty();
}
