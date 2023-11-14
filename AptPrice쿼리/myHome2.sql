--INSERT INTO ATP_TEST (NUM, TITLE, CONTENTS) 
--SELECT NUM, TITLE, CONTENTS 
--FROM ATP;
ROLLBACK;
INSERT INTO apt (
    APT_ID,
    city,
    street,
    bon_bun,
    bu_bun,
    dan_gi_myeong,
    square_meter,
    contract_date,
    contract_day,
    amount,
    layer,
    construction_date,
    road_name,
    reason_cancellation_date,
    transaction_type,
    location_agency
)SELECT
    ATP_SEQ.nextval,
    city,
    street,
    bon_bun,
    bu_bun,
    dan_gi_myeong,
    square_meter,
    contract_date,
    contract_day,
    amount,
    layer,
    construction_date,
    road_name,
    reason_cancellation_date,
    transaction_type,
    location_agency
FROM
    apt_test;


-- 상세 페이지
-- CITY, STREET, BON_BUN, BU_BUN, DAN_GI_MYEONG, SQUARE_METER, LAYER, CONSTRUCTION_DATE, 

SELECT
    * FROM apt
    where CITY = '울산광역시 북구 천곡동'
    and STREET = '940-6'
    and BON_BUN = '0940'
    and BU_BUN = '0006'
    and DAN_GI_MYEONG = '대동한마음타운'
    and SQUARE_METER = '59.79'
    and LAYER = '8'
    and CONSTRUCTION_DATE = '1998';
-- 울산광역시 북구 천곡동	940-6	0940	0006	대동한마음타운	59.79	202301	7	         8,900	8	1998	천곡길 165		중개거래	울산 북구	7152
SELECT *
     FROM apt
     where ROAD_NAME is null;
    where city like '%울산광역시 북구 천곡동%';

;


DROP TABLE APT;
commit;

SELECT  count(*)
     FROM apt;
     
drop SEQUENCE  ATP_SEQ;    

CREATE SEQUENCE ATP_SEQ
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 999999999
       NOCYCLE
       NOCACHE
       NOORDER;


false	CITY	null	100	false		시군구
false	STREET	null	50	false		번지
false	BON_BUN	null	50	false		본번
false	BU_BUN	null	50	false		부번
false	DAN_GI_MYEONG	null	100	false		단지명
false	SQUARE_METER	null	50	false		전용면적(㎡)
false	CONTRACT_DATE	null	50	false		계약년월
false	CONTRACT_DAY	null	50	false		계약일
false	AMOUNT	null	50	false		거래금액(만원)
false	LAYER	null	50	false		층
false	CONSTRUCTION_DATE	null	50	false		건축년도
false	ROAD_NAME	null	200	false		도로명
false	REASON_CANCELLATION_DATE	null	50	false		해제사유발생일
false	TRANSACTION_TYPE	null	50	false		거래유형
false	LOCATION_AGENCY	null	100	false		중개사소재지







