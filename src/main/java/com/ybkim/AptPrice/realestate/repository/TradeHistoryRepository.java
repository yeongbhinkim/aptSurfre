package com.ybkim.AptPrice.realestate.repository;

import com.ybkim.AptPrice.realestate.vo.TradeHistoryVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeHistoryRepository extends JpaRepository<TradeHistoryVO, Integer> {
}
