package com.ybkim.AptPrice.realestate.util;

import java.util.Random;

public class CustomTrxUtil {

    /**
     * 트랜잭션 번호를 생성한다.
     * @param startTime 현재 시간
     * @return 트랜잭션 번호
     * @author 정동욱
     */
    public static String generateTrxNo(String startTime) {
        Random random = new Random();
        String digits2 = String.valueOf(random.nextInt(90) + 10); // 11~99
        return startTime + digits2; // yyyyMMddHHmmssSSSXX
    }


    /**
     * API 트랜잭션 소요 시간을 구한다.
     * @param startTime 시작 시간
     * @param endTime 종료 시간
     * @return 소요 시간
     * @author 정동욱
     */
    public static long calculateTrxTime(String startTime, String endTime) {
        long startTimeInteger = Long.parseLong(startTime);
        long endTimeTimeInteger = Long.parseLong(endTime);
        return endTimeTimeInteger - startTimeInteger;
    }
}
