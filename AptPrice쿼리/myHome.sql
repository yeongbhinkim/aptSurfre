-- 차트 쿼리 시간 순서로 가격 동향 체크 조건은 조회조건 기간으로
SELECT CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0') day, AMOUNT
     FROM APT
--     where CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0') BETWEEN REPLACE('조회일자','-','') AND REPLACE('조회일자','-','')
     order by 1
     ;
     
     --거래일
SELECT DISTINCT CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0') day
--SELECT COUNT(DISTINCT CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0'))
     FROM APT
--     where CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0') BETWEEN REPLACE('조회일자','-','') AND REPLACE('조회일자','-','')
     order by 1
     ;     
     --거래 금액
SELECT AMOUNT
     FROM APT
--     where CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0') BETWEEN REPLACE('조회일자','-','') AND REPLACE('조회일자','-','')
     order by 1
     ;

--조회한 기간에 비교    
--월별 거래량
SELECT COUNT(*)
FROM APT
where CONTRACT_DATE = '202301';

SELECT a.*, GET_AMOUNT(CITY
,STREET
,BON_BUN
,BU_BUN
,DAN_GI_MYEONG
,SQUARE_METER
,LAYER
,CONSTRUCTION_DATE) as amountList
     FROM APT a;
     
     
  SELECT LISTAGG(CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0'),',') WITHIN GROUP (ORDER BY CONTRACT_DATE,LPAD(CONTRACT_DAY, 2, '0')) as CONTRACT
   FROM apt
    WHERE 1 = 1
      AND CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0') BETWEEN REPLACE('2023-01-01','-','') AND REPLACE('2023-02-10','-','') 
      AND CITY  LIKE '%'||REPLACE('부산광역시','전체','')||'%'||'%'||REPLACE('기장군','전체','')||'%'||'%'||REPLACE('정관읍','전체','')||'%'   
      AND TO_NUMBER(SUBSTR(SQUARE_METER, 1, INSTR(SQUARE_METER, '.') - 1)) BETWEEN  TO_NUMBER('0')  AND  TO_NUMBER('10000')
