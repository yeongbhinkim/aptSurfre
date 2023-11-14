package com.ybkim.AptPrice.realestate.repository;

import com.ybkim.AptPrice.realestate.vo.LeaseHistoryVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseHistoryRepository extends JpaRepository<LeaseHistoryVO, Integer> {
}
