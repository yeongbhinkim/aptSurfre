package com.ybkim.AptPrice.web.form.MyHomePrice;

import lombok.Data;

@Data
public class MyHomePriceListForm {

  private Long apt_id;                       // ID                         NUMBER               PK_시퀀스
  private String city;                       // CITY	                     VARCHAR2(100 BYTE)   시군구
  private String street;                     // STREET	                   VARCHAR2(50 BYTE)    번지
  private String bon_bun;                    // BON_BUN                    VARCHAR2(50 BYTE)    본번
  private String bu_bun;                     // BU_BUN	                   VARCHAR2(50 BYTE)    부번
  private String dan_gi_myeong;              // DAN_GI_MYEONG	             VARCHAR2(100 BYTE)   단지명
  private String square_meter;               // SQUARE_METER	             VARCHAR2(50 BYTE)    전용면적(㎡)
  private String contract;                   // CONTRACT_DATE	             GET_CONTRACT         계약년월일
  private String contract_date;              // CONTRACT_DATE	             VARCHAR2(50 BYTE)    계약년월
  private String contract_day;               // CONTRACT_DAY	             VARCHAR2(50 BYTE)    계약일
  private String amount;                     // AMOUNT	                   VARCHAR2(50 BYTE)    거래금액(만원)
//  private String amountlist;                 // AMOUNTLIST	               GET_AMOUNT           거래금액리스트
  private String TRANSACTIONCOUNTLIST;       // TRANSACTIONCOUNTLIST	     GET_TRANSACTIONCOUNT_LIST   거래금액리스트
  private String layer;                      // LAYER	                     VARCHAR2(50 BYTE)    층
  private String construction_date;          // CONSTRUCTION_DATE	         VARCHAR2(50 BYTE)    건축년도
  private String road_name;                  // ROAD_NAME	                 VARCHAR2(50 BYTE)    도로명
  private String reason_cancellation_date;   // REASON_CANCELLATION_DATE	 VARCHAR2(50 BYTE)    해제사유발생일
  private String transaction_type;           // TRANSACTION_TYPE	         VARCHAR2(50 BYTE)    거래유형
  private String location_agency;            // LOCATION_AGENCY	           VARCHAR2(100 BYTE)   중개사소재지


}
